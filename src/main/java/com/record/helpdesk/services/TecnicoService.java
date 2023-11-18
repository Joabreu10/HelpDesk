package com.record.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.record.helpdesk.domain.Tecnico;
import com.record.helpdesk.repositories.TecnicoRepository;
import com.record.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj  = tecnicoRepository.findById(id);
		return obj.orElseThrow(( )-> new ObjectnotFoundException("Objeto não encontrado! Id: " + id) );
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

}
