package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import br.fiap.assistencia_tecnica.web.dto.EquipamentoDTO;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EquipamentoService {
    private final ClienteRepository clienteRepository;
    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(ClienteRepository clienteRepository, EquipamentoRepository equipamentoRepository) {
        this.clienteRepository = clienteRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public Equipamento inserir(EquipamentoDTO dto) {
        var cliente = clienteRepository.findById(dto.getCliente().getId())
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

        var equipamento = new Equipamento();
        equipamento.setTipo(dto.getTipo());
        equipamento.setMarca(dto.getMarca());
        equipamento.setModelo(dto.getModelo());
        equipamento.setNumeroSerie(dto.getNumeroSerie());
        equipamento.setDataCadastro(dto.getDataCadastro());
        equipamento.setCliente(cliente);
        return equipamentoRepository.save(equipamento);
    }
}