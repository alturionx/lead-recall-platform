package br.com.alturionx.leadrecall.mensagem;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alturionx.leadrecall.mensagem.dto.MessageRequest;
import br.com.alturionx.leadrecall.mensagem.event.MessageReceivedEvent;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mensagens")
@RequiredArgsConstructor
public class MensagemController {

    private final ApplicationEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<Void> receive(@RequestBody MessageRequest request) {

        eventPublisher.publishEvent(
                new MessageReceivedEvent(request)
        );

        return ResponseEntity.accepted().build();
    }

}
