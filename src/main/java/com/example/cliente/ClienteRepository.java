package com.example.cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository
 extends JpaRepository<Cliente, Long>{
	
	@Query ("SELECT c from Cliente c WHERE c.cpf = ?1")
	Optional<Cliente> findClienteByCpf(String cpf);

}
