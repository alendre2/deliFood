package com.delifood.delifood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delifood.delifood.entity.Cidade;
import com.delifood.delifood.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar(){
		
		List<Cidade> cidades = cidadeRepository.findAll();
		
		return cidades;
	}

}
