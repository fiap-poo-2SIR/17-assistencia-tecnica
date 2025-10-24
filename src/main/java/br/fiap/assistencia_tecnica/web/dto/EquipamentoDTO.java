package br.fiap.assistencia_tecnica.web.dto;

import br.fiap.assistencia_tecnica.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoDTO {
    private Long id;
    private Cliente cliente;
    private String marca;
    private String modelo;
    private String tipo;
    private String numeroSerie;
    private LocalDate dataCadastro;
}
