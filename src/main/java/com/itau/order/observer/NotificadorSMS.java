package com.itau.order.observer;

import com.itau.order.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class NotificadorSMS implements ObservadorPedido {
    @Override
    public void notificar(Pedido pedido, String evento) {
        System.out.println("📱 [SMS] Para: " + pedido.getCliente().getTelefone());
        System.out.println("   Pedido #" + pedido.getId() + " - " + evento);
        System.out.println("   Status: " + pedido.getStatus().getDescricao());
        System.out.println("---");
    }

    @Override
    public String getTipo() {
        return "SMS";
    }
}
