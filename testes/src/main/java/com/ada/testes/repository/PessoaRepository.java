package com.ada.testes.repository;

import com.ada.testes.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    Optional<PessoaEntity> findByCpf(String cpf);

    Optional<PessoaEntity> findByEmail(String email);

}