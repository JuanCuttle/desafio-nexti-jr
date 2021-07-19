package com.example.produto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/produto")
public class ProdutoController {

	private final ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}


	@GetMapping
	public List<Produto> getProdutos() {
		return produtoService.getProdutos();
	}
	
	@PostMapping
	public void postProduto(@RequestBody Produto p) {
		produtoService.postProduto(p);
	}
	
	@DeleteMapping (path="{produtoId}")
	public void deleteProduto(@PathVariable("produtoId") Long id) {
		produtoService.deleteProduto(id);
	}
	
	@PutMapping (path="{produtoId}")
	@Transactional
	public void updateProduto(
			@PathVariable("produtoId") Long id,
			@RequestParam (required=false) String nome,
			@RequestParam (required=false) String descricao,
			@RequestParam (required=false) int preco,
			@RequestParam (required=false) int quantidade) {
		produtoService.updateProduto(id, nome, descricao, preco, quantidade);
	}
}
