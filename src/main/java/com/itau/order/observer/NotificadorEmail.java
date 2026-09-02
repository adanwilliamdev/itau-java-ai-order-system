package com.itau.order.observer;

import com.itau.order.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements ObservadorPedido {
    @Override
    public void notificar(Pedido pedido, String evento) {
        System.out.println("📧 [EMAIL] Para: " + pedido.getCliente().getEmail());
        System.out.println("   Assunto: Atualização do Pedido #" + pedido.getId());
        System.out.println("   Mensagem: " + evento);
        System.out.println("   Status atual: " + pedido.getStatus().getDescricao());
        System.out.println("---");
    }

    @Override
    public String getTipo() {
        return "EMAIL";
    }
}
