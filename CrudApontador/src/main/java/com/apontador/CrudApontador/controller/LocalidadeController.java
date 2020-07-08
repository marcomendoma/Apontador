package com.apontador.CrudApontador.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apontador.CrudApontador.domain.Localidade;
import com.apontador.CrudApontador.service.LocalidadeService;

@RestController
//@CrossOrigin("${origem-permitida}")
@RequestMapping("/localidades")
public class LocalidadeController {
	public static final Logger logger = LoggerFactory.getLogger(LocalidadeController.class);

	@Autowired
	LocalidadeService localidadeService;

	@PostMapping("/salvar")
	public Localidade save(@RequestBody Localidade localidade) {
		try {
			localidade = localidadeService.save(localidade);
		} catch (Exception be) {
			logger.error("Erro no metodo salvar localidade.");
			new Exception("Erro ao salvar localidade."); 
		}

		return localidade;
	}
	
	@PostMapping("/consultar")
	public Localidade finByEndereco(@RequestBody Localidade localidade) {
		Localidade localidadePesquisa = null;

		try {
			localidadePesquisa = localidadeService.findByEndereco(localidade.getEndereco());

			if (localidadePesquisa == null) {
				logger.info("Endereço não encontrado.");
				new Exception("Endereço " +  localidade.getEndereco()+ " não encontrado.");
			}

		} catch (Exception be) {
			logger.info("Erro ao pesquisar endereço " + be.getMessage());
			new Exception("Erro na rotina de pesquisar endereço. " + be.getMessage());
		}

		return localidadePesquisa;
	}

	@GetMapping
	public List<Localidade> list() {
		List<Localidade> localidades = null;

		try {
			localidades = localidadeService.list();
		} catch (Exception be) {
			logger.error("Erro ao Listar endereços " + be.getMessage());
			new Exception("Erro na rotina de Listar endereços. " + be.getMessage());
		}

		return localidades;
	}
	
	@GetMapping("/consultar/{id}")
	public Optional<Localidade> findOne(@PathVariable Long id) {
		Optional<Localidade> localidade = null;
		
		try {
			localidade = localidadeService.findById(id);
		} catch (Exception be) {
			logger.error("Erro ao pesquisar endereço com o id {0} " + be.getMessage(), id);
			new Exception("Erro na rotina de pesquisar endereço. " + be.getMessage());
		}

		return localidade;
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		try {
			localidadeService.delete(id);
		} catch (Exception be) {
			logger.error("Erro ao excluir o endereço com o id {0} " + be.getMessage(), id);
			new Exception("Erro ao remover endereço. " + be.getMessage());
		}
	}
}
