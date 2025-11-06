package br.fiap.assistencia_tecnica.repository;

import br.fiap.assistencia_tecnica.domain.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    public List<Equipamento> findByClienteId(Long idCliente);
}
