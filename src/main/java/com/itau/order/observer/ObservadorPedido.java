package com.itau.order.observer;

import com.itau.order.model.Pedido;

public interface ObservadorPedido {
    void notificar(Pedido pedido, String evento);
    String getTipo();
}