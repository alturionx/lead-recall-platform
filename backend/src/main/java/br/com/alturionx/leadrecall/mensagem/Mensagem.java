package br.com.alturionx.leadrecall.mensagem;

import java.time.LocalDateTime;

import br.com.alturionx.leadrecall.empresa.Empresa;
import br.com.alturionx.leadrecall.lead.Lead;
import br.com.alturionx.leadrecall.mensagem.enums.Canal;
import br.com.alturionx.leadrecall.mensagem.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_mensagens")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_id")
    private Lead lead;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Canal canal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status = Status.RECEBIDA;

    @Lob
    @Column(nullable = false)
    private String conteudo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {

        LocalDateTime now = LocalDateTime.now();

        if (dataCriacao == null) {
            dataCriacao = now;
        }

        if (status == null) {
            status = Status.RECEBIDA;
        }

    }

}