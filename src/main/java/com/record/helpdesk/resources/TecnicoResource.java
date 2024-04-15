package com.record.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.record.helpdesk.domain.Tecnico;
import com.record.helpdesk.domain.dtos.TecnicoDTO;
import com.record.helpdesk.services.TecnicoService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
	
	@Autowired
	TecnicoService tecnicoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> FindById(@PathVariable Integer id){
		Tecnico obj = tecnicoService.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity <List<TecnicoDTO>> FindAll(){
		List<Tecnico> list = tecnicoService.findAll();
		List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO){
		Tecnico newObj = tecnicoService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(null).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO objDTO) {
		//Tecnico obj;
		Tecnico obj = tecnicoService.update(id, objDTO);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}


	
	
}
