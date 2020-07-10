package com.musto.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.musto.rest.model.Evento;
import com.musto.rest.services.NewEventoService;
import com.musto.rest.services.RemoveEventoService;

@RestController
@RequestMapping(path = "rest/remove_evento")
public class RemoveEvento {
	
	@Autowired
	RemoveEventoService eventoService;   
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody String editEvento(EventoResource resource) throws Exception {
		String categoria = resource.getNome_categoria();
		String pwd = resource.getPassword();
		String user = resource.getUsername();
		int id = resource.getId_evento();
		System.out.println("---> "+resource.toString());
		return eventoService.removeEvento(user, pwd, categoria, id);
	}	
}
