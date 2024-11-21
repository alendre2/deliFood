package com.delifood.delifood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delifood.delifood.entity.Estado;
import com.delifood.delifood.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> listar(){
		
		List<Estado> estados = estadoRepository.findAll();
		
		return estados;
	}

}
