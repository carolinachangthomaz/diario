package com.carolinathomaz.api.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carolinathomaz.api.domain.Diario;
import com.carolinathomaz.api.dto.DiarioDto;
import com.carolinathomaz.api.service.DiarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/diario")
public class DiarioResource {

	@Autowired
	private DiarioService diarioService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<DiarioDto>>  findAll(){
		List<Diario> list = diarioService.findAll();
		List<DiarioDto> listDto = list.stream().map(cat -> new DiarioDto(cat)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<Diario>  findById(@PathVariable String id){
		Diario user = diarioService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<Diario>  insert(@RequestBody Diario diario){
		Diario diarionew = diarioService.insert(diario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(diarionew.getId()).toUri();
		return ResponseEntity.created(uri).body(diarionew);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void>  update(@RequestBody Diario diario){
		Diario newuser = diarioService.update(diario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newuser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
