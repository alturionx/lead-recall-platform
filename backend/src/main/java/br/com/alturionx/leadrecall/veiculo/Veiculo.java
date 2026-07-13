package br.com.alturionx.leadrecall.veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.alturionx.leadrecall.empresa.Empresa;
import br.com.alturionx.leadrecall.lead.enums.Transmissao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 80)
    private String modelo;

    @Column(length = 80)
    private String versao;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Transmissao transmissao;

    @Column(nullable = false)
    private Boolean disponivel = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void prePersist() {

        LocalDateTime now = LocalDateTime.now();

        dataCriacao = now;
        dataAtualizacao = now;

        if (disponivel == null) {
            disponivel = true;
        }
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

}