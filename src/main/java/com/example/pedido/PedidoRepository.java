package com.example.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interacao com o banco de dados de pedidos

@Repository
public interface PedidoRepository
 extends JpaRepository<Pedido, Long>{

}
