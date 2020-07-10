package com.musto.rest.services;

import org.springframework.stereotype.Service;

import com.musto.rest.db.DBConnection;
import com.musto.rest.model.Evento;

@Service("EditEventoService")
public class EditEventoService {
	
	public String editEvento(String user, String pwd, String categoria, Evento evento) throws Exception {
		String resp = null;
		int edit = -1;
		
		DBConnection db = new DBConnection();
        if(db.openConnection())
        	System.out.println("connessione con il db ok per edit evento");
        else
        	return null;

	    edit = db.modificaEvento(categoria, evento);
	    resp = Integer.toString(edit);   
   
        return resp;

	}
}