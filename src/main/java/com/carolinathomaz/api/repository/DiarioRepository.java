package com.carolinathomaz.api.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carolinathomaz.api.domain.Diario;

@Repository
public interface DiarioRepository extends MongoRepository<Diario, String>{

	Optional<Diario> findByPalavraIgnoreCaseContaining(String palavra);

	Diario findByDate(LocalDate ontem);

}
