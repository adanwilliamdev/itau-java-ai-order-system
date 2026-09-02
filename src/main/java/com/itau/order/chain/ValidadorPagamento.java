package com.itau.order.chain;

import com.itau.order.model.Pedido;
import com.itau.order.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPagamento extends ValidadorPedido {
    
    @Autowired
    private PagamentoService pagamentoService;

    @Override
    protected void processar(Pedido pedido) throws Exception {
        System.out.println("💳 Validando pagamento...");
        
        if (!pagamentoService.verificarCreditoCliente(pedido.getCliente().getId(), pedido.getValorTotal())) {
            throw new Exception("❌ Cliente sem crédito suficiente para o pedido");
        }
        System.out.println("✅ Pagamento validado com sucesso");
    }
}
