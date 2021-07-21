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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/produtos")
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
	
	@PutMapping
	@Transactional
	public void updateProduto(
			@RequestBody Produto p) {
		produtoService.updateProduto(p);
	}
}
