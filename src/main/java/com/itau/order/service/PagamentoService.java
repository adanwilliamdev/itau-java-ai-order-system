package com.itau.order.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoService {
    private Map<Long, Double> creditoClientes = new HashMap<>();

    public PagamentoService() {
        creditoClientes.put(1L, 10000.0);
        creditoClientes.put(2L, 500.0);
        creditoClientes.put(3L, 1500.0);
    }

    public boolean verificarCreditoCliente(Long clienteId, Double valor) {
        return creditoClientes.getOrDefault(clienteId, 0.0) >= valor;
    }

    public void processarPagamento(Long clienteId, Double valor) {
        if (verificarCreditoCliente(clienteId, valor)) {
            creditoClientes.put(clienteId, creditoClientes.get(clienteId) - valor);
            System.out.println("💰 Pagamento processado: Cliente " + clienteId + 
                             " | Valor: R$ " + String.format("%.2f", valor));
        } else {
            throw new RuntimeException("Crédito insuficiente para cliente " + clienteId);
        }
    }
}
