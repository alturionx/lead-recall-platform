package br.com.alturionx.leadrecall.ai;

import org.springframework.stereotype.Service;

import br.com.alturionx.leadrecall.ai.prompt.MessageAnalysisPrompt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIService {

    private final OllamaClient ollamaClient;

    public void analyze(String texto) {

        String prompt = MessageAnalysisPrompt.build(texto);

        String resposta = ollamaClient.generate(prompt);

        System.out.println();
        System.out.println("===== RESPOSTA DA IA =====");
        System.out.println(resposta);
        System.out.println("=========================");
    }
}