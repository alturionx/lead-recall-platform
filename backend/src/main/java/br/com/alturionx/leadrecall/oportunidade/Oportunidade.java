package br.com.alturionx.leadrecall.oportunidade;

import java.time.LocalDateTime;

import br.com.alturionx.leadrecall.empresa.Empresa;
import br.com.alturionx.leadrecall.lead.Lead;
import br.com.alturionx.leadrecall.veiculo.Veiculo;
import br.com.alturionx.leadrecall.oportunidade.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_oportunidades")
public class Oportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lead_id", nullable = false)
    private Lead lead;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Column(nullable = false)
    private Integer scoreCompatibilidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Status status = Status.NOVA;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    private LocalDateTime ultimaAtualizacao;

    @PrePersist
    public void prePersist() {

        LocalDateTime now = LocalDateTime.now();

        dataCriacao = now;
        ultimaAtualizacao = now;

        if (status == null) {
            status = Status.NOVA;
        }
    }

    @PreUpdate
    public void preUpdate() {
        ultimaAtualizacao = LocalDateTime.now();
    }

}