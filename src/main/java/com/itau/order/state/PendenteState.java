package com.itau.order.state;

import com.itau.order.model.Pedido;
import com.itau.order.enums.StatusPedido;

public class PendenteState implements StatePedido {
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PagoState());
        System.out.println("✅ Pedido #" + pedido.getId() + " movido para: PAGO");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoState());
        System.out.println("❌ Pedido #" + pedido.getId() + " cancelado");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.PENDENTE;
    }
}