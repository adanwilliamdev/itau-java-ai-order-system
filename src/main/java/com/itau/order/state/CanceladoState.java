package com.itau.order.state;

import com.itau.order.model.Pedido;
import com.itau.order.enums.StatusPedido;

public class CanceladoState implements StatePedido {
    @Override
    public void proximoEstado(Pedido pedido) {
        System.out.println("⛔ Pedido cancelado não pode mudar de estado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("⛔ Pedido já está cancelado");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.CANCELADO;
    }
}
