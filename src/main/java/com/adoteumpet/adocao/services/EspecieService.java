package com.adoteumpet.adocao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.dtos.EspecieDTO;
import com.adoteumpet.adocao.mappers.EspecieMapper;
import com.adoteumpet.adocao.repositories.EspecieRepository;

@Service
public class EspecieService {

	private EspecieMapper mapper;
	private EspecieRepository repository;


	@Autowired
	public EspecieService(EspecieRepository repository,EspecieMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}


	public List<EspecieDTO> buscarEspecies() {
		return mapper.toDTOList(repository.findAll());
	}
 
}
