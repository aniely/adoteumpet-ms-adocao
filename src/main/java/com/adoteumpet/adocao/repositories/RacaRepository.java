package com.adoteumpet.adocao.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoteumpet.adocao.entities.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long> {
	Optional<Raca> findById(Integer id);
	
	List<Raca> findByEspecie_id(Long id);
}
	 