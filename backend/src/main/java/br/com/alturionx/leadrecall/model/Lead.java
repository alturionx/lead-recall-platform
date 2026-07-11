package br.com.alturionx.leadrecall.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tb_leads")
@NoArgsConstructor
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Column(nullable = false, unique = true)
    private String phone;

    private String intent;

    private String vehicleInterest;

    private String brand;

    private String model;

    private Integer year;

    private Integer budget;

    private Integer score = 0;

    private String transmission;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime lastInteractionAt;

    @PrePersist
    public void prePersist() {

        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        updatedAt = now;
        lastInteractionAt = now;

        if (score == null) {
            score = 0;
        }

    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}