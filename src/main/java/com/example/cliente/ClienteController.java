package com.example.cliente;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Local onde as requisicoes sobre clientes sao direcionadas as suas respectivas funcoes
@RestController
@RequestMapping(path="api/v1/clientes")
public class ClienteController {

	// Referencia ao respectivo executor das requisicoes
	private final ClienteService clienteService;
	
	// Instanciacao automatica do executor
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	// Local onde inicia-se o processamento das requisicoes GET
	@GetMapping
	public List<Cliente> getClientes(@RequestHeader Map<String, String> mapValues) {
		System.out.println(mapValues);
		return clienteService.getClientes();
	}
	
	// Local onde inicia-se o processamento das requisicoes POST
	@PostMapping
	public void postCliente(@RequestBody Cliente c) {
		clienteService.postCliente(c);
	}
	
	// Local onde inicia-se o processamento das requisicoes DELETE
	// Nestas requisicoes, o id do cliente a ser excluido vai ao final da URL,
	// exemplo: http://localhost:8080/api/v1/clientes/1
	@DeleteMapping (path="{clienteId}")
	public void deleteCliente(@PathVariable("clienteId") Long id) {
		clienteService.deleteCliente(id);
	}
	
	// Local onde inicia-se o processamento das requisicoes PUT (atualizacao)
	// Para executa-las, basta enviar um novo cliente valido com o mesmo Id
	// Daquele que se deseja atualizar, junto com as informacoes novas
	@PutMapping
	@Transactional
	public void updateCliente(
			@RequestBody Cliente c) {
		clienteService.updateCliente(c);
	}
}
