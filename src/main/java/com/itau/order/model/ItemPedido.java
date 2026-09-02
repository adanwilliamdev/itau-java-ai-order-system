package com.itau.order.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private Double precoUnitario;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    
    public Double getSubtotal() {
        return quantidade * precoUnitario;
    }
}