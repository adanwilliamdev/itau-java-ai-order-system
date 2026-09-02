package com.itau.order.strategy;

import com.itau.order.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class FreteEconomicoStrategy implements CalculoFreteStrategy {
    @Override
    public Double calcular(Pedido pedido) {
        double pesoTotal = pedido.getItens().stream()
            .mapToDouble(item -> item.getQuantidade() * 5.0)
            .sum();
        double distancia = 15.0;
        
        double valor = (pesoTotal * 1.0) + (distancia * 0.3);
        System.out.println("📦 Frete Econômico: R$ " + String.format("%.2f", valor));
        return valor;
    }

    @Override
    public String getDescricao() {
        return "Frete Econômico - Entrega em 5-7 dias úteis";
    }
}