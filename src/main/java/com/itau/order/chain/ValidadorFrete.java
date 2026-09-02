package com.itau.order.chain;

import com.itau.order.model.Pedido;
import com.itau.order.enums.TipoFrete;
import org.springframework.stereotype.Component;

@Component
public class ValidadorFrete extends ValidadorPedido {
    @Override
    protected void processar(Pedido pedido) throws Exception {
        System.out.println("🚚 Validando frete...");
        
        if (pedido.getValorFrete() < 0) {
            throw new Exception("❌ Valor de frete inválido");
        }
        
        switch (pedido.getTipoFrete()) {
            case EXPRESSO:
                if (pedido.getValorFrete() > 100) {
                    throw new Exception("❌ Frete expresso muito caro para o pedido");
                }
                break;
            case ECONOMICO:
                if (pedido.getValorFrete() > 50) {
                    throw new Exception("❌ Frete econômico excede o valor máximo");
                }
                break;
            case RETIRADA_LOJA:
                if (pedido.getValorFrete() != 0) {
                    throw new Exception("❌ Retirada na loja deve ter frete zero");
                }
                break;
        }
        System.out.println("✅ Frete validado com sucesso");
    }
}
