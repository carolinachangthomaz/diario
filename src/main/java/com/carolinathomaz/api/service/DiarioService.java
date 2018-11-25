package com.carolinathomaz.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolinathomaz.api.domain.Diario;
import com.carolinathomaz.api.repository.DiarioRepository;

@Service
public class DiarioService {
	
	@Autowired
	private DiarioRepository diarioRepository;
	
	public Diario insert(Diario diario) {
		diario.setId(null);
		diario.setDate(LocalDate.now());
		return diarioRepository.insert(diario);
	}
	
	public Diario update(Diario diario) {
		Diario d = findById(diario.getId());
		d.setPalavra(diario.getPalavra());
		d.setObs(diario.getObs());
		return diarioRepository.save(d);
	}
	
	public Diario findById(String palavra) {
		Optional<Diario> obj = diarioRepository.findByPalavraIgnoreCaseContaining(palavra);
		
		return obj.orElseThrow(IllegalArgumentException::new);
	}

	public List<Diario> findAll() {
		return diarioRepository.findAll();
		
	}
	
	public void deleteAll() {
		this.diarioRepository.deleteAll();
		
	}

}
