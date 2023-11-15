package com.record.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.record.helpdesk.domain.Chamado;
import com.record.helpdesk.domain.Cliente;
import com.record.helpdesk.domain.Tecnico;
import com.record.helpdesk.domain.enums.Perfil;
import com.record.helpdesk.domain.enums.Prioridade;
import com.record.helpdesk.domain.enums.Status;
import com.record.helpdesk.repositories.ChamadoRepository;
import com.record.helpdesk.repositories.ClienteRepository;
import com.record.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	TecnicoRepository tecnicoRepository;
	@Autowired
	ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Thiago", "01223151712", "record@recordtvdf.com.br", "Record@2023");
		tec1.addPerfis(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Fernanda", "02123174213", "Fernanda@gmail.com", "Record@2023");
		cli1.addPerfis(Perfil.CLIENTE);
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
