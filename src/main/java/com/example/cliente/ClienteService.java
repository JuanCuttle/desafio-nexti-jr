package com.example.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	public void postCliente(Cliente c) {
		Optional<Cliente> clienteByCpf = clienteRepository.findClienteByCpf(c.getCpf());
		if (clienteByCpf.isPresent()) {
			throw new IllegalStateException("Cpf jah cadastrado");
		} else {
			clienteRepository.save(c);
		}

	}

	public void deleteCliente(Long id) {
		
		boolean clienteExists = clienteRepository.existsById(id);
		if (!clienteExists) {
			throw new IllegalStateException("Cliente com id "+id+" não existe!");
		} else {
			clienteRepository.deleteById(id);
		}
	}

	public void updateCliente(Cliente c) {
		Cliente cRep = clienteRepository.findById(c.getId()).orElseThrow(() -> new IllegalStateException("Cliente com id "+c.getId()+" não existe!"));
		
		cRep.setNome(c.getNome());
		cRep.setDataDeNascimento(c.getDataDeNascimento());
	}
}
