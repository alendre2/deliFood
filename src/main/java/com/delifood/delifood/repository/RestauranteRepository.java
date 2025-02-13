package com.delifood.delifood.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.delifood.delifood.entity.Cozinha;
import com.delifood.delifood.entity.Restaurante;


@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
	
	List<Restaurante> findByTaxaFreteBetween (BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	List<Restaurante> findByCozinha(Cozinha cozinha);
	
	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List <Restaurante> consultarPorNome(String nome, @Param("id") Long CozinhaId);

		
}
