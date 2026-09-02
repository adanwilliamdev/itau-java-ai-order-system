package com.itau.order;

import com.itau.order.model.Cliente;
import com.itau.order.model.ItemPedido;
import com.itau.order.model.Pedido;
import com.itau.order.observer.NotificadorEmail;
import com.itau.order.observer.NotificadorPush;
import com.itau.order.observer.NotificadorSMS;
import com.itau.order.service.PedidoService;
import com.itau.order.enums.TipoFrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OrderSystemApplication implements CommandLineRunner {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private NotificadorEmail notificadorEmail;

    @Autowired
    private NotificadorSMS notificadorSMS;

    @Autowired
    private NotificadorPush notificadorPush;

    public static void main(String[] args) {
        SpringApplication.run(OrderSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 INICIANDO SISTEMA DE PROCESSAMENTO DE PEDIDOS");
        System.out.println("===========================================\n");

        pedidoService.adicionarObservador(notificadorEmail);
        pedidoService.adicionarObservador(notificadorSMS);
        pedidoService.adicionarObservador(notificadorPush);

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João Silva");
        cliente.setEmail("joao@email.com");
        cliente.setTelefone("1199999999");
        cliente.setPreferenciasNotificacao(Arrays.asList("EMAIL", "SMS"));

        ItemPedido item1 = new ItemPedido();
        item1.setProdutoId(1L);
        item1.setNomeProduto("Notebook Dell");
        item1.setQuantidade(1);
        item1.setPrecoUnitario(4500.0);

        ItemPedido item2 = new ItemPedido();
        item2.setProdutoId(2L);
        item2.setNomeProduto("Mouse Logitech");
        item2.setQuantidade(2);
        item2.setPrecoUnitario(150.0);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setItens(List.of(item1, item2));
        pedido.setTipoFrete(TipoFrete.EXPRESSO);
        pedido.setObservacoes("Pedido de teste - Frete Expresso");

        Pedido pedidoCriado = pedidoService.criarPedido(pedido);

        Thread.sleep(2000);
        pedidoService.atualizarEstadoPedido(pedidoCriado.getId());

        Thread.sleep(2000);
        pedidoService.atualizarEstadoPedido(pedidoCriado.getId());

        Thread.sleep(2000);
        pedidoService.atualizarEstadoPedido(pedidoCriado.getId());

        System.out.println("\n===========================================");
        System.out.println("🏁 PROCESSO CONCLUÍDO COM SUCESSO!");
        System.out.println("===========================================");
    }
}
