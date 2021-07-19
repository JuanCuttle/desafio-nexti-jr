package com.example.pedido;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class Pedido {
	@Id
	@SequenceGenerator(
			name = "pedido_sequence",
			sequenceName = "pedido_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "pedido_sequence"
	)
	private long id;
	private long idCliente;
	private int totalDaCompra;
	private LocalDate dataDaCompra;
	private ArrayList<Long> produtos;	

	public Pedido() {
	}

	public Pedido(long id, long idCliente, int totalDaCompra, LocalDate dataDaCompra, ArrayList<Long> produtos) {
		this.id = id;
		this.idCliente = idCliente;
		this.totalDaCompra = totalDaCompra;
		this.dataDaCompra = dataDaCompra;
		this.produtos = produtos;
	}

	public Pedido(long idCliente, int totalDaCompra, LocalDate dataDaCompra, ArrayList<Long> produtos) {
		this.idCliente = idCliente;
		this.totalDaCompra = totalDaCompra;
		this.dataDaCompra = dataDaCompra;
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idCliente=" + idCliente + ", totalDaCompra=" + totalDaCompra + ", dataDaCompra="
				+ dataDaCompra + ", produtos=" + produtos + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public int getTotalDaCompra() {
		return totalDaCompra;
	}

	public void setTotalDaCompra(int totalDaCompra) {
		this.totalDaCompra = totalDaCompra;
	}

	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public ArrayList<Long> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Long> produtos) {
		this.produtos = produtos;
	}

}
