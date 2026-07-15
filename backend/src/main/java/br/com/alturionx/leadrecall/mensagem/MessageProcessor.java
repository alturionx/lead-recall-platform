package br.com.alturionx.leadrecall.mensagem;

import org.springframework.stereotype.Service;

import br.com.alturionx.leadrecall.empresa.Empresa;
import br.com.alturionx.leadrecall.empresa.EmpresaRepository;
import br.com.alturionx.leadrecall.mensagem.dto.MessageRequest;
import br.com.alturionx.leadrecall.mensagem.event.MessageReceivedEvent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageProcessor {

    private final EmpresaRepository empresaRepository;
    private final MensagemRepository mensagemRepository;

    public void process(MessageReceivedEvent event){

        MessageRequest request = event.request();

        Empresa empresa = empresaRepository.findById(
                request.empresaId()
        ).orElseThrow();

        Mensagem mensagem = new Mensagem();

        mensagem.setEmpresa(empresa);
        mensagem.setTelefone(request.telefone());
        mensagem.setConteudo(request.conteudo());
        mensagem.setCanal(request.canal());

        mensagemRepository.save(mensagem);

    }

}