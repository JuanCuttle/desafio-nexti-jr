package com.example.pedido;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoConfig {

	@Bean
	CommandLineRunner commandLineRunner(PedidoRepository repository) {
		return args -> {
			Pedido p1 = new Pedido(1, 1, 100, LocalDate.of(2020, Month.AUGUST, 12), new ArrayList<Long>(1));
			Pedido p2 = new Pedido(2, 2, 500, LocalDate.of(2020, Month.AUGUST, 12), new ArrayList<Long>(1));
			
			repository.saveAll(List.of(p1, p2));
		};
	}
}
