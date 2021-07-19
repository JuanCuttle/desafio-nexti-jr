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

@RestController
@RequestMapping(path="api/v1/pedido")
public class PedidoController {

	private final PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}


	@GetMapping
	public List<Pedido> getPedidos() {
		return pedidoService.getPedidos();
	}
	
	@PostMapping
	public void postPedido(@RequestBody Pedido p) {
		pedidoService.postPedido(p);
	}
	
	@DeleteMapping (path="{pedidoId}")
	public void deletePedido(@PathVariable("pedidoId") Long id) {
		pedidoService.deletePedido(id);
	}
	
	@PutMapping
	@Transactional
	public void updatePedido(
			@RequestBody Pedido p) {
		pedidoService.updatePedido(p);
	}
}
