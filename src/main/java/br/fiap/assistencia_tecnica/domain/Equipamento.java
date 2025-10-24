package br.fiap.assistencia_tecnica.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "JAVA_EQUIPAMENTO")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIP")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE", nullable = false,
        foreignKey = @ForeignKey(name = "FK_EQUIP_CLIENTE"))
    private Cliente cliente;

    private String marca;
    private String modelo;
    private String tipo;
    private String numeroSerie;
    private LocalDate dataCadastro;
}
