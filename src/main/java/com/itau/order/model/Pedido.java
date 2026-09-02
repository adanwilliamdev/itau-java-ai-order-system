package com.itau.order.model;

import com.itau.order.enums.StatusPedido;
import com.itau.order.enums.TipoFrete;
import com.itau.order.state.StatePedido;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private Double valorTotal;
    private Double valorFrete;
    private TipoFrete tipoFrete;
    private StatusPedido status;
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
