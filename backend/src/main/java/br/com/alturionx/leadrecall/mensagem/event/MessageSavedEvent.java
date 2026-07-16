package br.com.alturionx.leadrecall.mensagem.event;

import br.com.alturionx.leadrecall.mensagem.Mensagem;

public record MessageSavedEvent(
        Mensagem mensagem) {

}
