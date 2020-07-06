package com.apontador.CrudApontador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apontador.CrudApontador.domain.Localidade;
import com.apontador.CrudApontador.repository.LocalidadeRepository;

@Service
public class LocalidadeService {

	@Autowired
	LocalidadeRepository localidadeRepository;
	
	public Localidade save(Localidade localidade) {
		return localidadeRepository.save(localidade);
	}
	
	public Localidade findByEndereco(String endereco) {
		return localidadeRepository.findByEndereco(endereco);
	}
	
	public Optional<Localidade> findById(Long id) {
		return localidadeRepository.findById(id);
	}
	
	public List<Localidade> list() {
		return localidadeRepository.findAll();
	}
	
	public void delete(Long id) {
		localidadeRepository.deleteById(id);
	}
}
