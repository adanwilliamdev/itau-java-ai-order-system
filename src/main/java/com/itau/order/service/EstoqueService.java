package com.itau.order.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EstoqueService {
    private Map<Long, Integer> estoque = new HashMap<>();

    public EstoqueService() {
        estoque.put(1L, 100);
        estoque.put(2L, 50);
        estoque.put(3L, 25);
        estoque.put(4L, 0);
    }

    public boolean verificarDisponibilidade(Long produtoId, Integer quantidade) {
        return estoque.getOrDefault(produtoId, 0) >= quantidade;
    }

    public void baixarEstoque(Long produtoId, Integer quantidade) {
        if (verificarDisponibilidade(produtoId, quantidade)) {
            estoque.put(produtoId, estoque.get(produtoId) - quantidade);
            System.out.println("📦 Baixa de estoque: Produto " + produtoId + 
                             " | Quantidade: " + quantidade);
        } else {
            throw new RuntimeException("Estoque insuficiente para produto " + produtoId);
        }
    }
}
