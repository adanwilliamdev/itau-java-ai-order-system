package com.itau.order.state;

import com.itau.order.model.Pedido;
import com.itau.order.enums.StatusPedido;

public class EntregueState implements StatePedido {
    @Override
    public void proximoEstado(Pedido pedido) {
        System.out.println("⛔ Pedido já foi entregue");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("⛔ Não é possível cancelar pedido entregue");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.ENTREGUE;
    }
}