package br.com.alturionx.leadrecall.mensagem.dto;

import br.com.alturionx.leadrecall.mensagem.enums.Canal;

public record MessageRequest(
        Long empresaId,
        String telefone,
        String conteudo,
        Canal canal
    ) {
}
