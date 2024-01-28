package com.record.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.record.helpdesk.domain.Pessoa;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

   Optional<Pessoa> findByCpf(String cpf);
   Optional<Pessoa> findByEmail(String email);


}
 