package com.itau.order.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();
    
    private Double valorTotal;
    private Double valorFrete;
    private String tipoFrete;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private String observacoes;
}