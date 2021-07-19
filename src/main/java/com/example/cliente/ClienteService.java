package com.example.cliente;

import java.time.LocalDate;
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

	public void updateCliente(Long id, String nome, String dob) {
		Cliente c = clienteRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cliente com id "+id+" não existe!"));
		
		c.setNome(nome);
		if (dob != null) {
			c.setDataDeNascimento(LocalDate.parse(dob));
		}
	}
}
