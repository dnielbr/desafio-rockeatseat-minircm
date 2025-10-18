package io.github.daniel.mini_rmc;

import io.github.daniel.mini_rmc.entity.Cliente;
import io.github.daniel.mini_rmc.entity.Contato;
import io.github.daniel.mini_rmc.repository.ClienteRepository;
import io.github.daniel.mini_rmc.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MiniRmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniRmcApplication.class, args);
	}

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ContatoRepository contatoRepository;

	@Bean
	public CommandLineRunner startup(){

		return args -> {

			Cliente daniel = clienteRepository.save(new Cliente("Daniel", "daniel@gmail.com"));
			Cliente maria = clienteRepository.save(new Cliente("Maria", "maria@gmail.com"));

			contatoRepository.save(new Contato("telefone", "83900222109", daniel));
			contatoRepository.save(new Contato("email", "maria@gmail.com", maria));

			System.out.println("Banco de Dados iniciado!");
        };
	}

}
