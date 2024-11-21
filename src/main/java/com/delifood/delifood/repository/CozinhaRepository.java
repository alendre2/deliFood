package com.delifood.delifood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delifood.delifood.entity.Cozinha;
import com.delifood.delifood.entity.Restaurante;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	
	List<Cozinha> findBynome(String nome);


}
