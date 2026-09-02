package com.itau.order.strategy;

import com.itau.order.model.Pedido;

public interface CalculoFreteStrategy {
    Double calcular(Pedido pedido);
    String getDescricao();
}
