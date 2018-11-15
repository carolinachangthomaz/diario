package com.carolinathomaz.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carolinathomaz.api.domain.Diario;
import com.carolinathomaz.api.service.DiarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/diario")
public class DiarioResource {

	@Autowired
	private DiarioService diarioService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Diario>>  findAll(){
		List<Diario> list = diarioService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<Diario>  findById(@PathVariable String id){
		Diario user = diarioService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>  insert(@RequestBody Diario user){
		Diario newuser = diarioService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newuser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void>  update(@RequestBody Diario user){
		Diario newuser = diarioService.update(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newuser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
