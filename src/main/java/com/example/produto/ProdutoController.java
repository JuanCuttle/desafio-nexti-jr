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

//Local onde as requisicoes sobre produtos sao direcionadas as suas respectivas funcoes
@RestController
@RequestMapping(path="api/v1/produtos")
public class ProdutoController {

	// Referencia ao respectivo executor das requisicoes
	private final ProdutoService produtoService;
	
	// Instanciacao automatica do executor
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	// Local onde inicia-se o processamento das requisicoes GET
	@GetMapping
	public List<Produto> getProdutos() {
		return produtoService.getProdutos();
	}
	
	// Local onde inicia-se o processamento das requisicoes POST	
	@PostMapping
	public void postProduto(@RequestBody Produto p) {
		produtoService.postProduto(p);
	}
	
	// Local onde inicia-se o processamento das requisicoes DELETE
	// Nestas requisicoes, o id do produto a ser excluido vai ao final da URL,
	// exemplo: http://localhost:8080/api/v1/produtos/1
	@DeleteMapping (path="{produtoId}")
	public void deleteProduto(@PathVariable("produtoId") Long id) {
		produtoService.deleteProduto(id);
	}
	
	// Local onde inicia-se o processamento das requisicoes PUT (atualizacao)
	// Para executa-las, basta enviar um novo produto valido com o mesmo Id
	// Daquele que se deseja atualizar, junto com as informacoes novas
	@PutMapping
	@Transactional
	public void updateProduto(
			@RequestBody Produto p) {
		produtoService.updateProduto(p);
	}
}
