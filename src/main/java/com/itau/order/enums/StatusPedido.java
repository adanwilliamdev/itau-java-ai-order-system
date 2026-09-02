package com.itau.order.enums;

public enum StatusPedido {
    PENDENTE("Aguardando processamento"),
    PAGO("Pagamento confirmado"),
    ENVIADO("Pedido enviado"),
    ENTREGUE("Pedido entregue"),
    CANCELADO("Pedido cancelado");

    private String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}