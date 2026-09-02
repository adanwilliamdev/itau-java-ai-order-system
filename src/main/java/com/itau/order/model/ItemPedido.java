package com.itau.order.model;

import lombok.Data;

@Data
public class ItemPedido {
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private Double precoUnitario;
    
    public Double getSubtotal() {
        return quantidade * precoUnitario;
    }
}
