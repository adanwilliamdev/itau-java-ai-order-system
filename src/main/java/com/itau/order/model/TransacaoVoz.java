package com.itau.order.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class TransacaoVoz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private String comandoOriginal;
    private String textoTranscrito;
    private String acaoExecutada;
    private String resultado;
    private LocalDateTime dataProcessamento;
}