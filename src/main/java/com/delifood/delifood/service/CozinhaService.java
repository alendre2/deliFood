package com.delifood.delifood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.delifood.delifood.entity.Cozinha;
import com.delifood.delifood.entity.Restaurante;
import com.delifood.delifood.exception.EntidadeEmUsoException;
import com.delifood.delifood.exception.EntidadeNaoEncontradaException;
import com.delifood.delifood.repository.CozinhaRepository;

import jakarta.transaction.Transactional;

@Service
public class CozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;	
	
	public List<Cozinha> listar(){
		
		List<Cozinha> cozinhas = cozinhaRepository.findAll();  
		return cozinhas;
	}
	
	public Cozinha buscarOuFalhar(Long id) {
		return cozinhaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe um cadastro de cozinha código %d.", id)));
	}
	
	
	@Transactional
	public  Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	@Transactional
	public void remover(Cozinha cozinha) {
		try {
			cozinhaRepository.delete(cozinha);
			cozinhaRepository.flush();
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida pois está em uso.", cozinha.getId()));
		}
	}
	
	public List<Cozinha> buscarNome(String nome){
		return cozinhaRepository.findBynome(nome);
	}
	
	

	//Estudar Transação BD e ACID
	//ResponseEntity
	
	
	
	
	
}
