package com.example.pedido;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository
 extends JpaRepository<Pedido, Long>{
	
	@Query ("SELECT p from Produto p WHERE p.nome = ?1")
	Optional<Pedido> findProdutoByNome(String nome);

}
