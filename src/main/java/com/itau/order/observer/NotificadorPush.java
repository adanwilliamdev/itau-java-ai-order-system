package com.itau.order.observer;

import com.itau.order.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class NotificadorPush implements ObservadorPedido {
    @Override
    public void notificar(Pedido pedido, String evento) {
        System.out.println("📲 [PUSH] Para usuário: " + pedido.getCliente().getNome());
        System.out.println("   Título: Atualização do pedido #" + pedido.getId());
        System.out.println("   Mensagem: " + evento);
        System.out.println("   Status: " + pedido.getStatus().getDescricao());
        System.out.println("---");
    }

    @Override
    public String getTipo() {
        return "PUSH";
    }
}
