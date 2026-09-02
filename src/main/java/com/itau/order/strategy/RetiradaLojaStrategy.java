package com.itau.order.strategy;

import com.itau.order.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class RetiradaLojaStrategy implements CalculoFreteStrategy {
    @Override
    public Double calcular(Pedido pedido) {
        System.out.println("🏪 Retirada na Loja - Frete grátis");
        return 0.0;
    }

    @Override
    public String getDescricao() {
        return "Retirada na Loja - Sem custo de frete";
    }
}