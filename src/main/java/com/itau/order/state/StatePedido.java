package com.itau.order.state;

import com.itau.order.model.Pedido;
import com.itau.order.enums.StatusPedido;

public interface StatePedido {
    void proximoEstado(Pedido pedido);
    void cancelar(Pedido pedido);
    StatusPedido getStatus();
}