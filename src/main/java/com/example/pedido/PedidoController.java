package com.example.pedido;

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

//Local onde as requisicoes sobre pedidos sao direcionadas as suas respectivas funcoes
@RestController
@RequestMapping(path="api/v1/pedidos")
public class PedidoController {

	// Referencia ao respectivo executor das requisicoes
	private final PedidoService pedidoService;
	
	// Instanciacao automatica do executor
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	// Local onde inicia-se o processamento das requisicoes GET
	@GetMapping
	public List<Pedido> getPedidos() {
		return pedidoService.getPedidos();
	}
	
	// Local onde inicia-se o processamento das requisicoes POST	
	@PostMapping
	public void postPedido(@RequestBody Pedido p) {
		pedidoService.postPedido(p);
	}
	
	// Local onde inicia-se o processamento das requisicoes DELETE
	// Nestas requisicoes, o id do pedido a ser excluido vai ao final da URL,
	// exemplo: http://localhost:8080/api/v1/pedidos/1
	@DeleteMapping (path="{pedidoId}")
	public void deletePedido(@PathVariable("pedidoId") Long id) {
		pedidoService.deletePedido(id);
	}
	
	// Local onde inicia-se o processamento das requisicoes PUT (atualizacao)
	// Para executa-las, basta enviar um novo pedido valido com o mesmo Id
	// Daquele que se deseja atualizar, junto com as informacoes novas
	@PutMapping
	@Transactional
	public void updatePedido(
			@RequestBody Pedido p) {
		pedidoService.updatePedido(p);
	}
}
