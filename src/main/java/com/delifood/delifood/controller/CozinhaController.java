package com.delifood.delifood.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delifood.delifood.entity.Cozinha;
import com.delifood.delifood.exception.EntidadeEmUsoException;
import com.delifood.delifood.exception.EntidadeNaoEncontradaException;
import com.delifood.delifood.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaService cozinhaService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Cozinha> listar(){
		List<Cozinha> cozinhas = cozinhaService.listar();
		return cozinhas;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id){
		try {
			Cozinha cozinha = cozinhaService.buscarOuFalhar(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		}catch (EntidadeNaoEncontradaException e ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha){
		try {
			Cozinha cozinhaAtual = cozinhaService.buscarOuFalhar(id);
			
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			
			cozinhaAtual = cozinhaService.salvar(cozinhaAtual);
			
			return ResponseEntity.status(HttpStatus.OK).body(cozinhaAtual);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>remover(@PathVariable Long id){
		try {
			Cozinha cozinha = cozinhaService.buscarOuFalhar(id);
			cozinhaService.remover(cozinha);
			return ResponseEntity.notFound().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}catch (EntidadeEmUsoException e ) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/consultas/nome")
	public List<Cozinha> buscarNome(@RequestParam String nome){
		return cozinhaService.buscarNome(nome);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cozinhaService.salvar(cozinha);
	}
		
	
	

}
