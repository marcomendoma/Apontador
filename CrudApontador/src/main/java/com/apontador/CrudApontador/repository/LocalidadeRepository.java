package com.apontador.CrudApontador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apontador.CrudApontador.domain.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long>{
	@Query(
			value = " Select * from localidade " +
					" where endereco = :endereco ",
			nativeQuery = true
	)
	Localidade findByEndereco(String endereco);
}
