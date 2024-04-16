package com.record.helpdesk.services;
import com.record.helpdesk.domain.Cliente;
import com.record.helpdesk.domain.Pessoa;
import com.record.helpdesk.domain.dtos.ClienteDTO;
import com.record.helpdesk.repositories.ClienteRepository;
import com.record.helpdesk.repositories.PessoaRepository;
import com.record.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.record.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj  = clienteRepository.findById(id);
		return obj.orElseThrow(( )-> new ObjectnotFoundException("Objeto não encontrado! Id: " + id) );
	}

	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return clienteRepository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return clienteRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getChamados().size() > 0){
			throw new DataIntegrityViolationException("Cliente possui chamado ordens de serviço e não pode ser deletado");
		}
			clienteRepository.deleteById(id);

	}

	private void validaPorCpfEEmail(ClienteDTO objDTO) {
		Optional <Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}

		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}



}
