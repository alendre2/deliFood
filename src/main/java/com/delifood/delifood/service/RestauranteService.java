package com.delifood.delifood.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delifood.delifood.entity.Cozinha;
import com.delifood.delifood.entity.Restaurante;
import com.delifood.delifood.exception.EntidadeNaoEncontradaException;
import com.delifood.delifood.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaService cozinhaService;
	
	public List<Restaurante> listar(){
		
		List<Restaurante> restaurante = restauranteRepository.findAll();
		return restaurante;
	}
	
	public Restaurante buscarOuFalha(Long id) {
		return restauranteRepository.findById(id)
				.orElseThrow(() ->new EntidadeNaoEncontradaException(
						String.format("Não existe um cadastro de registro código %d.", id)));
	}
	
	public List<Restaurante> buscarPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	public List<Restaurante> consultarPorCozinha(Long cozinhaId) {
		Cozinha cozinha = cozinhaService.buscarOuFalhar(cozinhaId); 
		return restauranteRepository.findByCozinha(cozinha);
	}
	
	public List<Restaurante> consultarPorNome(String nome, Long cozinhaId) {
		
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	

}
