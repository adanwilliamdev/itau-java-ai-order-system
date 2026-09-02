package com.itau.order.model;

import lombok.Data;
import java.util.List;

@Data
public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private List<String> preferenciasNotificacao;
}
