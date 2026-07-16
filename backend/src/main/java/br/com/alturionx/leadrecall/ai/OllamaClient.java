package br.com.alturionx.leadrecall.ai;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import br.com.alturionx.leadrecall.ai.dto.OllamaRequest;
import br.com.alturionx.leadrecall.ai.dto.OllamaResponse;

@Component
public class OllamaClient {

    private final RestClient restClient;

    public OllamaClient() {

        this.restClient = RestClient.builder()
                .baseUrl("http://leadrecall-ai:11434")
                .build();
    }

    public String generate(String prompt) {

        OllamaRequest request = new OllamaRequest(
                "qwen2.5:3b",
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