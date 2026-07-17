package br.com.alturionx.leadrecall.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import br.com.alturionx.leadrecall.ai.dto.OllamaRequest;
import br.com.alturionx.leadrecall.ai.dto.OllamaResponse;

@Component
public class OllamaClient {

    private final RestClient restClient;
    private final String model;

    public OllamaClient(
            @Value("${ollama.url}") String url,
            @Value("${ollama.model}") String model) {

        this.model = model;

        this.restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    public String generate(String prompt) {

        OllamaRequest request = new OllamaRequest(
                model,
                prompt,
                false
        );

        OllamaResponse response = restClient.post()
                .uri("/api/generate")
                .body(request)
                .retrieve()
                .body(OllamaResponse.class);

        return response.response();
    }
}