package com.example.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}

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

	public void deleteProduto(Long id) {
		
		boolean produtoExists = produtoRepository.existsById(id);
		if (!produtoExists) {
			throw new IllegalStateException("Produto com id "+id+" não existe!");
		} else {
			produtoRepository.deleteById(id);
		}
	}

	public void updateProduto(Long id, String nome, String descricao, int preco, int quantidade) {
		Produto p = produtoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Produto com id "+id+" não existe!"));

		p.setNome(nome);
		p.setDescricao(descricao);
		p.setPreco(preco);
		p.setQuantidade(quantidade);
	}
}
