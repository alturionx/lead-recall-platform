package br.com.alturionx.leadrecall.ai.dto;

public record OllamaRequest(
        String model,
        String prompt,
        boolean stream
) {
}