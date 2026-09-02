package com.itau.order.service;

import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AudioTranscriptionService {

    @Autowired
    private OpenAiAudioTranscriptionModel transcriptionModel;

    public String transcreverAudio(MultipartFile file) throws Exception {
        var options = org.springframework.ai.audio.transcription.AudioTranscriptionOptions.builder()
            .withModel("whisper-1")
            .withLanguage("pt")
            .withTemperature(0.3)
            .build();
            
        var response = transcriptionModel.call(
            new java.io.ByteArrayInputStream(file.getBytes()),
            options
        );
        
        return response.getText();
    }
}