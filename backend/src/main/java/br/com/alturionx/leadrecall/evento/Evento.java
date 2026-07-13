package br.com.alturionx.leadrecall.evento;

import java.time.LocalDateTime;

import br.com.alturionx.leadrecall.empresa.Empresa;
import br.com.alturionx.leadrecall.evento.enums.Entidade;
import br.com.alturionx.leadrecall.evento.enums.Origem;
import br.com.alturionx.leadrecall.evento.enums.Tipo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_eventos", indexes = {
        @Index(name = "idx_evento_empresa", columnList = "empresa_id"),
        @Index(name = "idx_evento_tipo", columnList = "tipo"),
        @Index(name = "idx_evento_data", columnList = "data_criacao"),
        @Index(name = "idx_evento_entidade", columnList = "entidade, entidade_id")
})
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Origem origem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Entidade entidade;

    @Column(name = "entidade_id", nullable = false)
    private Long entidadeId;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String payload;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String resultado;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_processamento")
    private LocalDateTime dataProcessamento;

    @PrePersist
    public void prePersist() {

        if (dataCriacao == null) {
            dataCriacao = LocalDateTime.now();
        }

    }

}