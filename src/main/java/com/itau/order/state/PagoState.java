package com.itau.order.state;

import com.itau.order.model.Pedido;
import com.itau.order.enums.StatusPedido;

public class PagoState implements StatePedido {
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new EnviadoState());
        System.out.println("📦 Pedido #" + pedido.getId() + " movido para: ENVIADO");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoState());
        System.out.println("❌ Pedido #" + pedido.getId() + " cancelado (reembolso será processado)");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.PAGO;
    }
}
