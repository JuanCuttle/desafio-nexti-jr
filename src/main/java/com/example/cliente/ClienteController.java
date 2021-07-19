package com.example.cliente;

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
@RequestMapping(path="api/v1/cliente")
public class ClienteController {

	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}


	@GetMapping
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}
	
	@PostMapping
	public void postCliente(@RequestBody Cliente c) {
		clienteService.postCliente(c);
	}
	
	@DeleteMapping (path="{clienteId}")
	public void deleteCliente(@PathVariable("clienteId") Long id) {
		clienteService.deleteCliente(id);
	}
	
	@PutMapping (path="{clienteId}")
	@Transactional
	public void updateCliente(
			@PathVariable("clienteId") Long id,
			@RequestParam (required=false) String nome,
			@RequestParam (required=false) String dataDeNascimento) {
		clienteService.updateCliente(id, nome, dataDeNascimento);
	}
}
