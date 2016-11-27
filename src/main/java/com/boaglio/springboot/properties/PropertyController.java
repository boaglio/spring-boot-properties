package com.boaglio.springboot.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
@RequestMapping("/api")
public class PropertyController {
	
	@Autowired
	private PropertyRepository repository;

	@RequestMapping(method = RequestMethod.GET,value="/find/all")
	public	List<Property> findAll() {
		return (List<Property>) repository.findAll();
	}

	@RequestMapping(value = "/find/name/{name}", method = RequestMethod.GET)
	List<Property>  findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}
	
	@RequestMapping(value = "/find/{filtro}", method = RequestMethod.GET)
	List<Property>  findByFiltro(@PathVariable("filtro") String filtro) {
		return repository.findByFiltro(filtro);
	}

}
