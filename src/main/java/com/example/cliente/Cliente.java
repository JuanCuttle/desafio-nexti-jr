package com.example.cliente;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
	@Id
	@SequenceGenerator(
			name = "cliente_sequence",
			sequenceName = "cliente_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "cliente_sequence"
	)
	private long id;
	private String nome;
	private String cpf;
	private LocalDate dataDeNascimento;

	public Cliente() {
	}

	// Construtor com todos os campos para testes
	public Cliente(long id,
			String nome,
			String cpf,
			LocalDate dataDeNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}

	// Construtor sem Id para geracao automatica pelo banco de dados
	public Cliente(String nome,
			String cpf,
			LocalDate dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
