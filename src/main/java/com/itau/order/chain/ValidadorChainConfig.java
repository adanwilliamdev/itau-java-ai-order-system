package com.itau.order.chain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidadorChainConfig {

    @Autowired
    private ValidadorEstoque validadorEstoque;

    @Autowired
    private ValidadorPagamento validadorPagamento;

    @Autowired
    private ValidadorFrete validadorFrete;

    @Bean
    public ValidadorPedido validadorChain() {
        // Configurar a ordem: Estoque -> Pagamento -> Frete
        validadorEstoque.setProximo(validadorPagamento);
        validadorPagamento.setProximo(validadorFrete);
        
        System.out.println("✅ Chain de validação configurada: Estoque → Pagamento → Frete");
        return validadorEstoque;
    }
}