package com.itau.order.strategy;

import com.itau.order.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class FreteExpressoStrategy implements CalculoFreteStrategy {
    private static final double PESO_FIXO = 10.0;

    @Override
    public Double calcular(Pedido pedido) {
        double pesoTotal = pedido.getItens().stream()
            .mapToDouble(item -> item.getQuantidade() * PESO_FIXO)
            .sum();
        double distancia = 15.0;
        
        double valor = (pesoTotal * 2.0) + (distancia * 0.5) + 15.0;
        System.out.println("📦 Frete Expresso: R$ " + String.format("%.2f", valor));
        return valor;
    }

    @Override
    public String getDescricao() {
        return "Frete Expresso - Entrega em 24h";
    }
}