package br.com.alturionx.leadrecall.mensagem.event;

import br.com.alturionx.leadrecall.mensagem.dto.MessageRequest;

public record MessageReceivedEvent(
        MessageRequest request
) {
}