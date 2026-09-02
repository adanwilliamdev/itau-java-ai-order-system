package com.itau.order.service;

import com.itau.order.chain.ValidadorPedido;
import com.itau.order.model.Pedido;
import com.itau.order.observer.ObservadorPedido;
import com.itau.order.strategy.CalculoFreteStrategy;
import com.itau.order.state.PendenteState;
import com.itau.order.enums.TipoFrete;
import com.itau.order.enums.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<ObservadorPedido> observadores = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private List<CalculoFreteStrategy> estrategiasFrete;

    @Autowired
    private ValidadorPedido validadorChain;

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private PagamentoService pagamentoService;

    public Pedido criarPedido(Pedido pedido) throws Exception {
        System.out.println("\n🔄 INICIANDO CRIAÇÃO DO PEDIDO #" + nextId);
        
        pedido.setId(nextId++);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setDataAtualizacao(LocalDateTime.now());
        
        double totalItens = pedido.getItens().stream()
            .mapToDouble(item -> item.getSubtotal())
            .sum();
        pedido.setValorTotal(totalItens);
        
        CalculoFreteStrategy estrategia = encontrarEstrategia(pedido.getTipoFrete());
        double valorFrete = estrategia.calcular(pedido);
        pedido.setValorFrete(valorFrete);
        pedido.setValorTotal(totalItens + valorFrete);
        
        System.out.println("\n🔍 INICIANDO VALIDAÇÕES...");
        validadorChain.validar(pedido);
        System.out.println("✅ TODAS AS VALIDAÇÕES PASSARAM!\n");
        
        estoqueService.baixarEstoque(pedido.getItens().get(0).getProdutoId(), 
                                    pedido.getItens().get(0).getQuantidade());
        pagamentoService.processarPagamento(pedido.getCliente().getId(), 
                                          pedido.getValorTotal());
        
        pedido.setEstado(new PendenteState());
        pedidos.add(pedido);
        
        notificarObservadores(pedido, "Pedido criado com sucesso!");
        
        System.out.println("✅ PEDIDO #" + pedido.getId() + " CRIADO COM SUCESSO!");
        System.out.println("   Total: R$ " + String.format("%.2f", pedido.getValorTotal()));
        System.out.println("   Status: " + pedido.getStatus().getDescricao() + "\n");
        
        return pedido;
    }

    public void atualizarEstadoPedido(Long pedidoId) throws Exception {
        Pedido pedido = buscarPedido(pedidoId);
        if (pedido == null) {
            throw new Exception("Pedido não encontrado");
        }
        
        System.out.println("\n🔄 ATUALIZANDO ESTADO DO PEDIDO #" + pedidoId);
        StatusPedido statusAnterior = pedido.getStatus();
        pedido.proximoEstado();
        
        String evento = "Status atualizado: " + statusAnterior.getDescricao() + 
                       " → " + pedido.getStatus().getDescricao();
        notificarObservadores(pedido, evento);
        
        System.out.println("✅ Estado atualizado com sucesso!\n");
    }

    public void cancelarPedido(Long pedidoId) throws Exception {
        Pedido pedido = buscarPedido(pedidoId);
        if (pedido == null) {
            throw new Exception("Pedido não encontrado");
        }
        
        System.out.println("\n❌ CANCELANDO PEDIDO #" + pedidoId);
        pedido.cancelar();
        
        String evento = "Pedido cancelado - " + pedido.getObservacoes();
        notificarObservadores(pedido, evento);
        
        System.out.println("✅ Pedido cancelado com sucesso!\n");
    }

    private CalculoFreteStrategy encontrarEstrategia(TipoFrete tipo) {
        return estrategiasFrete.stream()
            .filter(e -> {
                switch(tipo) {
                    case EXPRESSO: return e instanceof com.itau.order.strategy.FreteExpressoStrategy;
                    case ECONOMICO: return e instanceof com.itau.order.strategy.FreteEconomicoStrategy;
                    case RETIRADA_LOJA: return e instanceof com.itau.order.strategy.RetiradaLojaStrategy;
                    default: return false;
                }
            })
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Estratégia de frete não encontrada"));
    }

    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }

    private void notificarObservadores(Pedido pedido, String evento) {
        System.out.println("\n📢 NOTIFICANDO OBSERVADORES...");
        observadores.stream()
            .filter(obs -> pedido.getCliente().getPreferenciasNotificacao().contains(obs.getTipo()))
            .forEach(obs -> obs.notificar(pedido, evento));
    }

    public Pedido buscarPedido(Long id) {
        return pedidos.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}