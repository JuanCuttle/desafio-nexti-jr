package com.example.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cliente.ClienteRepository;
import com.example.produto.ProdutoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final ProdutoRepository produtoRepository;
	private final ClienteRepository clienteRepository;


	@Autowired
	public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.clienteRepository = clienteRepository;
	}

	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}

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

	public void deletePedido(Long id) {
		
		boolean pedidoExists = pedidoRepository.existsById(id);
		if (!pedidoExists) {
			throw new IllegalStateException("Pedido com id "+id+" não existe!");
		} else {
			pedidoRepository.deleteById(id);
		}
	}

	public void updatePedido(Pedido p) {
		Pedido pRep = pedidoRepository.findById(p.getId()).orElseThrow(() -> new IllegalStateException("Pedido com id "+p.getId()+" não existe!"));

		pRep.setIdCliente(p.getIdCliente());
		pRep.setTotalDaCompra(p.getTotalDaCompra());
		pRep.setDataDaCompra(p.getDataDaCompra());
		
		ArrayList<Long> idProdutos = p.getProdutos();
		for (int i = 0; i < idProdutos.size();  i++) {
			Long idProduto = idProdutos.get(i);
			System.out.println(idProduto);
			if (!produtoRepository.existsById(idProduto)) {
				throw new IllegalStateException("Produto com id "+idProduto+" não existe!");
			}
		}
		pRep.setProdutos(p.getProdutos());
	}
}
