package com.example.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Classe que executara as requisicoes sobre produtos dos usuarios
@Service
public class ProdutoService {

	// Referencia a tabela de produto do banco de dados
	private final ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	// Metodo GET. Retorna uma lista com todos os produtos
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}

	// Metodo POST. Verifica se o produto ja esta cadastrado. Caso afirmativo lanca um erro,
	// caso negativo verifica se o id ja esta sendo utilizado por outro produto. Caso afrimativo
	// lanca um erro, caso negativo inclui o novo produto
	public void postProduto(Produto p) {
		Optional<Produto> produtoByNome = produtoRepository.findProdutoByNome(p.getNome());
		if (produtoByNome.isPresent()) {
			throw new IllegalStateException("Produto jah cadastrado");
		} else {
			Optional<Produto> produtoById = produtoRepository.findById(p.getId());
			if (produtoById.isPresent())
			{
				throw new IllegalStateException("Id jah cadastrado");
			} else {
				produtoRepository.save(p);
			}
		}

	}

	// Metodo DELETE. Caso o produto solicitado nao exista, lanca um erro. Caso contrario, o exclui
	public void deleteProduto(Long id) {
		
		boolean produtoExists = produtoRepository.existsById(id);
		if (!produtoExists) {
			throw new IllegalStateException("Produto com id "+id+" não existe!");
		} else {
			produtoRepository.deleteById(id);
		}
	}

	// Metodo PUT (atualizar). Caso o produto solicitado nao esteja cadastrado, lanca um erro.
	// Caso contrario atualiza nome, descricao, preco e quantidade
	public void updateProduto(Produto p) {
		Produto pRep = produtoRepository.findById(p.getId()).orElseThrow(() -> new IllegalStateException("Produto com id "+p.getId()+" não existe!"));

		pRep.setNome(p.getNome());
		pRep.setDescricao(p.getDescricao());
		pRep.setPreco(p.getPreco());
		pRep.setQuantidade(p.getQuantidade());
	}
}
