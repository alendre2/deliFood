package com.delifood.delifood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delifood.delifood.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
