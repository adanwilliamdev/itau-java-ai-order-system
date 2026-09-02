package com.itau.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderSystemApplication.class, args);
        System.out.println("============================================");
        System.out.println("  SISTEMA DE PEDIDOS COM IA");
        System.out.println("============================================");
        System.out.println("  Swagger: http://localhost:8080/swagger-ui.html");
        System.out.println("  H2: http://localhost:8080/h2-console");
        System.out.println("============================================");
    }
}
