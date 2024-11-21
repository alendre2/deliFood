package com.delifood.delifood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delifood.delifood.entity.Cidade;
import com.delifood.delifood.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar(){
		List<Cidade> cidades = cidadeService.listar();
		return cidades;
	}
	
	

}
