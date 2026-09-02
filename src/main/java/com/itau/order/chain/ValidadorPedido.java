package com.itau.order.chain;

import com.itau.order.model.Pedido;

public abstract class ValidadorPedido {
    protected ValidadorPedido proximo;

    public void setProximo(ValidadorPedido proximo) {
        this.proximo = proximo;
    }

    public void validar(Pedido pedido) throws Exception {
        processar(pedido);
        if (proximo != null) {
            proximo.validar(pedido);
        }
    }

    protected abstract void processar(Pedido pedido) throws Exception;
}