package com.itau.order.state;

import com.itau.order.model.Pedido;
import com.itau.order.enums.StatusPedido;

public class EnviadoState implements StatePedido {
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new EntregueState());
        System.out.println("✅ Pedido #" + pedido.getId() + " movido para: ENTREGUE");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("⛔ Não é possível cancelar pedido já enviado");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.ENVIADO;
    }
}
