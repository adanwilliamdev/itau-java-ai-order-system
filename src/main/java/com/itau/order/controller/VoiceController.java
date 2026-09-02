package com.itau.order.controller;

import com.itau.order.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/voz")
public class VoiceController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/processar")
    public ResponseEntity<?> processarComandoVoz(
            @RequestParam("audio") MultipartFile audio,
            @RequestParam("clienteId") Long clienteId) {
        try {
            // Simulação: extrair nome do arquivo como comando
            String nomeArquivo = audio.getOriginalFilename();
            String comandoSimulado = nomeArquivo != null ? nomeArquivo.replace(".wav", "").replace(".mp3", "") : "desconhecido";
            
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("clienteId", clienteId);
            resultado.put("comando", comandoSimulado);
            resultado.put("tamanhoAudio", audio.getSize());
            resultado.put("tipoAudio", audio.getContentType());
            
            // Simular processamento baseado no nome do arquivo
            String comando = comandoSimulado.toUpperCase();
            if (comando.contains("PEDIDO") || comando.contains("CRIAR")) {
                resultado.put("intencao", "CRIAR_PEDIDO");
                resultado.put("mensagem", "Comando de criação de pedido recebido!");
                resultado.put("acao", "PEDIDO_SIMULADO");
            } else if (comando.contains("SALDO") || comando.contains("CONSULTAR")) {
                resultado.put("intencao", "CONSULTAR_SALDO");
                resultado.put("mensagem", "Saldo consultado: R$ 1.500,00");
                resultado.put("saldo", 1500.00);
                resultado.put("acao", "SALDO_CONSULTADO");
            } else if (comando.contains("LISTAR") || comando.contains("PEDIDOS")) {
                resultado.put("intencao", "LISTAR_PEDIDOS");
                resultado.put("mensagem", "Listando pedidos...");
                resultado.put("pedidos", pedidoService.listarPedidos());
                resultado.put("acao", "PEDIDOS_LISTADOS");
            } else if (comando.contains("AJUDA")) {
                resultado.put("intencao", "AJUDA");
                resultado.put("mensagem", "Comandos disponíveis: CRIAR_PEDIDO, CONSULTAR_SALDO, LISTAR_PEDIDOS");
                resultado.put("acao", "AJUDA");
            } else {
                resultado.put("intencao", "DESCONHECIDO");
                resultado.put("mensagem", "Comando não reconhecido. Use: criar_pedido, consultar_saldo, listar_pedidos");
                resultado.put("acao", "DESCONHECIDO");
            }
            
            resultado.put("status", "SUCESSO");
            resultado.put("modo", "SIMULADO (Spring AI não disponível)");
            return ResponseEntity.ok(resultado);
            
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("error", e.getMessage());
            erro.put("status", "ERRO");
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> status() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "online");
        status.put("service", "Voice System (Modo Simulado)");
        status.put("version", "1.0.0");
        status.put("modo", "SIMULADO - Spring AI não configurado");
        status.put("mensagem", "Para testar, envie um arquivo de áudio com o comando no nome");
        return ResponseEntity.ok(status);
    }
}