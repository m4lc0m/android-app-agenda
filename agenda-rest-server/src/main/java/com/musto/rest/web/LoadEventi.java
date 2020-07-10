package com.musto.rest.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.musto.rest.model.Evento;
import com.musto.rest.services.LoadEventiService;

@RestController
@RequestMapping(path = "rest/load_eventi")
public class LoadEventi {
	
	@Autowired
	LoadEventiService eventoService;   
	

	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Evento> loadEventi(EventoResource resource) throws Exception {
		String categoria = resource.getNome_categoria();
		String pwd = resource.getPassword();
		String user = resource.getUsername();
		System.out.println("category___"+resource.getNome_categoria());
		return eventoService.getEventi(user, pwd, categoria);
		
	}

}
