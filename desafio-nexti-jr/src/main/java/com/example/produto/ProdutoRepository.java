package com.example.produto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository
 extends JpaRepository<Produto, Long>{
	
	@Query ("SELECT p from Produto p WHERE p.nome = ?1")
	Optional<Produto> findProdutoByNome(String nome);

}
