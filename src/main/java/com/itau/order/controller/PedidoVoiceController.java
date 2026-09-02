package com.itau.order.controller;

import com.itau.order.service.AudioTranscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/voz")
public class PedidoVoiceController {

    @Autowired
    private AudioTranscriptionService audioService;

    @PostMapping("/processar")
    public ResponseEntity<?> processarAudio(
            @RequestParam("audio") MultipartFile audio,
            @RequestParam("clienteId") Long clienteId) {
        try {
            String texto = audioService.transcreverAudio(audio);
            
            Map<String, Object> resposta = new HashMap<>();
            resposta.put("clienteId", clienteId);
            resposta.put("textoTranscrito", texto);
            resposta.put("mensagem", "Audio processado com sucesso!");
            resposta.put("status", "SUCESSO");
            
            return ResponseEntity.ok(resposta);
            
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }
}