package com.itau.order.model;

import com.itau.order.enums.StatusPedido;
import com.itau.order.enums.TipoFrete;
import com.itau.order.state.StatePedido;
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
    
    @Enumerated(EnumType.STRING)
    private TipoFrete tipoFrete;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Transient
    private StatePedido estadoAtual;
    
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private String observacoes;

    public void setEstado(StatePedido estado) {
        this.estadoAtual = estado;
        this.status = estado.getStatus();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void proximoEstado() {
        if (estadoAtual != null) {
            estadoAtual.proximoEstado(this);
        }
    }

    public void cancelar() {
        if (estadoAtual != null) {
            estadoAtual.cancelar(this);
        }
    }
}