package br.com.alturionx.leadrecall.ai;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.alturionx.leadrecall.mensagem.event.MessageSavedEvent;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AIProcessor {

    private final AIService aiService;

    @EventListener
    public void process(MessageSavedEvent event) {

        var mensagem = event.mensagem();

        aiService.analyze(
                mensagem.getConteudo()
        );

    }
}