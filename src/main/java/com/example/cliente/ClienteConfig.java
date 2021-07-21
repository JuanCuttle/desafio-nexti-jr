package com.example.cliente;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Classe para montar bancos de dados dummy para testes
@Configuration
public class ClienteConfig {

	/*
	 * @Bean CommandLineRunner commandLineRunner(ClienteRepository repository) {
	 * return args -> { Cliente alice = new Cliente("Alice", "012.345.678-90",
	 * LocalDate.of(2000, Month.JANUARY, 5)); Cliente bob = new Cliente("Bob",
	 * "098.765.432-10", LocalDate.of(2004, Month.APRIL, 15));
	 * 
	 * repository.saveAll(List.of(alice, bob)); }; }
	 */
}
