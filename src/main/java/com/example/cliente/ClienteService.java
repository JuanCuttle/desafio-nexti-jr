package com.example.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Classe que executara as requisicoes sobre clientes dos usuarios
@Service
public class ClienteService {

	// Referencia a tabela de cliente do banco de dados
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// Metodo GET. Retorna uma lista com todos os clientes
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	// Metodo POST. Verifica se o cliente ja esta cadastrado. Caso afirmativo lanca um erro,
	// em caso negativo inclui o novo cliente
	public void postCliente(Cliente c) {
		Optional<Cliente> clienteByCpf = clienteRepository.findClienteByCpf(c.getCpf());
		if (clienteByCpf.isPresent()) {
			throw new IllegalStateException("Cpf jah cadastrado");
		} else {
			clienteRepository.save(c);
		}

	}

	// Metodo DELETE. Caso o cliente solicitado nao exista, lanca um erro. Caso contrario, o exclui
	public void deleteCliente(Long id) {
		
		boolean clienteExists = clienteRepository.existsById(id);
		if (!clienteExists) {
			throw new IllegalStateException("Cliente com id "+id+" não existe!");
		} else {
			clienteRepository.deleteById(id);
		}
	}

	// Metodo PUT (atualizar). Caso o cliente solicitado nao esteja cadastrado, lanca um erro.
	// Caso contrario atualiza nome e data de nascimento
	public void updateCliente(Cliente c) {
		Cliente cRep = clienteRepository.findById(c.getId()).orElseThrow(() -> new IllegalStateException("Cliente com id "+c.getId()+" não existe!"));
		
		cRep.setNome(c.getNome());
		cRep.setDataDeNascimento(c.getDataDeNascimento());
	}
}
