package com.example.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cliente.ClienteRepository;
import com.example.produto.ProdutoRepository;

//Classe que executara as requisicoes sobre pedidos dos usuarios
@Service
public class PedidoService {

	// Referencias as tabelas do banco de dados
	private final PedidoRepository pedidoRepository;
	private final ProdutoRepository produtoRepository;
	private final ClienteRepository clienteRepository;


	@Autowired
	public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.clienteRepository = clienteRepository;
	}

	// Metodo GET. Retorna uma lista com todos os pedidos
	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}

	// Metodo POST. Verifica se o pedido ja esta registrado no banco de dados. Caso afirmativo
	// lanca um erro, caso negativo verifica se o cliente referenciado no pedido esta cadastrado. Caso
	// negativo lanca um erro, caso afirmativo verifica o mesmo para os produtos referenciados no pedido.
	// Caso o cliente e os produtos ja estejam todos registrados no banco de dados, salva o novo pedido
	public void postPedido(Pedido p) {
		Optional<Pedido> pedidoById = pedidoRepository.findById(p.getId());
		if (pedidoById.isPresent()) {
			throw new IllegalStateException("Pedido jah cadastrado");
		} else {
			
			boolean clienteExistsById = clienteRepository.existsById(p.getIdCliente());
			
			if (!clienteExistsById) {
				throw new IllegalStateException("Cliente de id "+p.getIdCliente()+" ainda nao cadastrado");
			}
			
			for (int i = 0; i < p.getProdutos().size(); i++) {
				Long idProduto = p.getProdutos().get(i);
				if (!produtoRepository.existsById(idProduto)) {
					throw new IllegalStateException("Produto de id "+idProduto+" ainda nao cadastrado");
				}
			}
			pedidoRepository.save(p);
		}

	}

	// Metodo DELETE. Caso o pedido solicitado nao exista, lanca um erro. Caso contrario, o exclui
	public void deletePedido(Long id) {
		
		boolean pedidoExists = pedidoRepository.existsById(id);
		if (!pedidoExists) {
			throw new IllegalStateException("Pedido com id "+id+" não existe!");
		} else {
			pedidoRepository.deleteById(id);
		}
	}

	// Metodo PUT (atualizar). Caso o pedido solicitado nao esteja cadastrado, lanca um erro.
	// Caso contrario, verifica se o cliente novo esta cadastrado. Caso nao esteja lanca um erro.
	// Caso esteja, verifica se os ids dos produtos no pedido atualizado ja estao
	// no banco de dados. Caso algum nao esteja, lanca um erro. Caso todos estejam,
	// atualiza o id do cliente, o valor total da compra, a data da compra e as
	// referencias dos produtos associados ao pedido
	public void updatePedido(Pedido p) {
		Pedido pRep = pedidoRepository.findById(p.getId()).orElseThrow(() -> new IllegalStateException("Pedido com id "+p.getId()+" não existe!"));

		Long idCliente = p.getIdCliente();
		boolean clienteExiste = clienteRepository.existsById(idCliente);
		
		if (!clienteExiste) {
			throw new IllegalStateException("Cliente com id "+idCliente+" não existe!");
		}
		
		ArrayList<Long> idProdutos = p.getProdutos();
		for (int i = 0; i < idProdutos.size();  i++) {
			Long idProduto = idProdutos.get(i);
			if (!produtoRepository.existsById(idProduto)) {
				throw new IllegalStateException("Produto com id "+idProduto+" não existe!");
			}
		}
		
		pRep.setIdCliente(p.getIdCliente());
		pRep.setTotalDaCompra(p.getTotalDaCompra());
		pRep.setDataDaCompra(p.getDataDaCompra());
		pRep.setProdutos(p.getProdutos());
	}
}
