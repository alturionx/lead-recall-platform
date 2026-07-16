package br.com.alturionx.leadrecall.lead;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.alturionx.leadrecall.empresa.Empresa;
import br.com.alturionx.leadrecall.lead.enums.Intencao;
import br.com.alturionx.leadrecall.lead.enums.Transmissao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_leads", uniqueConstraints = {@UniqueConstraint(columnNames = {"empresa_id", "phone"})})
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Intencao intencao = Intencao.DESCONHECIDA;

    @Column(length = 80)
    private String veiculoInteresse;

    private Integer ano;

    @Column(length = 2000)
    private String resumo;

    @Column(precision = 12, scale = 2)
    private BigDecimal orcamento;

    @Column(nullable = false)
    private Integer score = 0;

    @Enumerated(EnumType.STRING)
    private Transmissao transmissao;

    /**
     * Nível de confiança da IA (0 a 100)
     */
    private Integer confianca;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

    @Column(nullable = false)
    private LocalDateTime ultimaInteracao;

    @PrePersist
    public void prePersist() {

        LocalDateTime now = LocalDateTime.now();

        dataCriacao = now;
        dataAtualizacao = now;
        ultimaInteracao = now;

        if (score == null) {
            score = 0;
        }

        if (intencao == null) {
            intencao = Intencao.DESCONHECIDA;
        }
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

}