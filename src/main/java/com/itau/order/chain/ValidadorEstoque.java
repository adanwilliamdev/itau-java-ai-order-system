package com.itau.order.chain;

import com.itau.order.model.Pedido;
import com.itau.order.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorEstoque extends ValidadorPedido {
    
    @Autowired
    private EstoqueService estoqueService;

    @Override
    protected void processar(Pedido pedido) throws Exception {
        System.out.println("🔍 Validando estoque...");
        
        for (var item : pedido.getItens()) {
            if (!estoqueService.verificarDisponibilidade(item.getProdutoId(), item.getQuantidade())) {
                throw new Exception("❌ Produto " + item.getNomeProduto() + " sem estoque suficiente");
            }
        }
        System.out.println("✅ Estoque validado com sucesso");
    }
}