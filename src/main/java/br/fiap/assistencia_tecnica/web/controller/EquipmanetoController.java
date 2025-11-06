package br.fiap.assistencia_tecnica.web.controller;

import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.service.EquipamentoService;
import br.fiap.assistencia_tecnica.web.dto.EquipamentoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipamento")
public class EquipmanetoController {

    private final EquipamentoService service;

    public EquipmanetoController(EquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    public Equipamento cadastrar(@RequestBody EquipamentoDTO dto) {
        return service.inserir(dto);
    }

}
