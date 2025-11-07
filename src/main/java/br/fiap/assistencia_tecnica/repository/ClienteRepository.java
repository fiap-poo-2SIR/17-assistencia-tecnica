package br.fiap.assistencia_tecnica.repository;

import br.fiap.assistencia_tecnica.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   public Optional<Cliente> findByEmail(String email);
}
