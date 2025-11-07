package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import br.fiap.assistencia_tecnica.web.config.SenhaConfig;
import br.fiap.assistencia_tecnica.web.dto.ClienteDTO;
import br.fiap.assistencia_tecnica.web.dto.LoginDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repositorio;
    private final EquipamentoRepository equipamentoRepository;
    private final SenhaConfig senhaConfig;

    public ClienteService(ClienteRepository repositorio,
                          EquipamentoRepository equipamentoRepository,
                          SenhaConfig senhaConfig) {
        this.repositorio = repositorio;
        this.equipamentoRepository = equipamentoRepository;
        this.senhaConfig = senhaConfig;
    }

    public Cliente cadastrar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(senhaConfig.encoder().encode(clienteDTO.getSenha()));
        cliente.setTelefone(clienteDTO.getTelefone());
        return repositorio.save(cliente);
    }

    public List<Cliente> listar() {
        return repositorio.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Equipamento> listarEquipamentoPorCliente(Long id) {
        return equipamentoRepository.findByClienteId(id);
    }

    public boolean autenticar(LoginDTO dto) {
        return repositorio.findByEmail(dto.getEmail())
                .map(c -> senhaConfig.encoder().matches(dto.getSenha(), c.getSenha()))
                .orElse(false);

    }

}
