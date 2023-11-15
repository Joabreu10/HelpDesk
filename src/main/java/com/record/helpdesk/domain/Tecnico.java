package com.record.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.record.helpdesk.domain.enums.Perfil;

@Entity
public class Tecnico extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
		addPerfis(Perfil.TECNICO);
	}

	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfis(Perfil.TECNICO);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	

}
