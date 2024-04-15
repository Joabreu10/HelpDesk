package com.record.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.record.helpdesk.domain.Chamado;
import com.record.helpdesk.domain.Cliente;
import com.record.helpdesk.domain.Tecnico;
import com.record.helpdesk.domain.enums.Perfil;
import com.record.helpdesk.domain.enums.Prioridade;
import com.record.helpdesk.domain.enums.Status;
import com.record.helpdesk.repositories.ChamadoRepository;
import com.record.helpdesk.repositories.ClienteRepository;
import com.record.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	TecnicoRepository tecnicoRepository;
	
	@Autowired
	ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {	
		
		Tecnico tec1 = new Tecnico(null, "Jonas Victor", "04143079178", "jonas@recordtvdf.com.br", "Record@2023");
		tec1.addPerfis(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Fernanda", "05181940196", "Fernanda@gmail.com", "Record@2023");
		cli1.addPerfis(Perfil.CLIENTE);
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
