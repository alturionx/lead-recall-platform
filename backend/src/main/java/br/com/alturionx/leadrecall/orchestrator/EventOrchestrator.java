package br.com.alturionx.leadrecall.orchestrator;

import br.com.alturionx.leadrecall.mensagem.MessageProcessor;
import br.com.alturionx.leadrecall.mensagem.event.MessageReceivedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventOrchestrator {

    private final MessageProcessor messageProcessor;

    @EventListener
    public void onMessageReceived(MessageReceivedEvent event) {
        messageProcessor.process(event);
    }

}