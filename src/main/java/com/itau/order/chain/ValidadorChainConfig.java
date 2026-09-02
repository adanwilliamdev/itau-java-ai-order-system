package com.itau.order.chain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ValidadorChainConfig {

    @Bean
    @Primary
    public ValidadorPedido validadorChain(
            ValidadorEstoque validadorEstoque,
            ValidadorPagamento validadorPagamento,
            ValidadorFrete validadorFrete) {
        
        validadorEstoque.setProximo(validadorPagamento);
        validadorPagamento.setProximo(validadorFrete);
        
        System.out.println("✅ Chain configurada: Estoque → Pagamento → Frete");
        return validadorEstoque;
    }
}