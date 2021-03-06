package com.musto.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.musto.rest.model.Evento;
import com.musto.rest.services.NewEventoService;

@RestController
@RequestMapping(path = "rest/add_evento")
public class NewEvento {
	
	@Autowired
	NewEventoService eventoService;   
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Evento addEvento(EventoResource resource) throws Exception {
		String categoria = resource.getNome_categoria();
		String pwd = resource.getPassword();
		String user = resource.getUsername();
		System.out.println("---> "+resource.toString());
		Evento evento = new Evento(0, resource.getNomeEvento(), resource.getDataEvento(), 
								resource.getOraEvento(), resource.getDescrizioneEvento(), 
								resource.getLuogoEvento(), resource.getNoteAggiuntiveEvento());
		
		return eventoService.addEvento(user, pwd, categoria, evento);
			
	}

}
