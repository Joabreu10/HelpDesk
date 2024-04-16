package com.record.helpdesk.services;

import com.record.helpdesk.domain.Chamado;
import com.record.helpdesk.domain.dtos.ChamadoDTO;
import com.record.helpdesk.repositories.ChamadoRepository;
import com.record.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    ChamadoRepository chamadoRepository;

    public Chamado findById(Integer id){
        Optional <Chamado> obj = chamadoRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! ID: " +id));
    }

    public List<Chamado> findAll(){
        return chamadoRepository.findAll();
    }

}
