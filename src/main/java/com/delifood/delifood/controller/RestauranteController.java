package com.delifood.delifood.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delifood.delifood.entity.Restaurante;
import com.delifood.delifood.exception.EntidadeNaoEncontradaException;
import com.delifood.delifood.repository.RestauranteRepository;
import com.delifood.delifood.service.RestauranteService;

@RestController
@RequestMapping ("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private RestauranteService restauranteService;
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/consultas/por-taxa-frete")
	public List<Restaurante>  buscarPorTaxaFrete(@RequestParam BigDecimal taxaInicial,@RequestParam BigDecimal taxaFinal){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);   
	}
	
	@GetMapping("/consultas/por-cozinha")
	public ResponseEntity<List<Restaurante>> consultarPorCozinha (
			@RequestParam("cozinhaId") Long cozinhaId) {
		try {
			List<Restaurante> restaurantes = restauranteService.consultarPorCozinha(cozinhaId);
			return ResponseEntity.status(HttpStatus.OK).body(restaurantes);
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}	
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping ("/consultar/por-nome")
	public List<Restaurante> consultarPorNome(@RequestParam String nome, @RequestParam Long cozinhaId){
		
		return  restauranteService.consultarPorNome(nome, cozinhaId);
		
		
	}
	
	
	
}
