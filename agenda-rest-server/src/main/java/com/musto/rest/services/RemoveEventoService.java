package com.musto.rest.services;

import org.springframework.stereotype.Service;

import com.musto.rest.db.DBConnection;
import com.musto.rest.model.Evento;

@Service("RemoveEventoService")
public class RemoveEventoService {
	
	public String removeEvento(String user, String pwd, String categoria, int id_evento) throws Exception {
		 String resp = null;
        DBConnection db = new DBConnection();
        if(db.openConnection())
        	System.out.println("connessione con il db ok per remove evento");
        else
        	return null;
        
    	int rem = 0;
        rem = db.removeEvento(categoria, id_evento);
        resp = Integer.toString(rem);
        
        return resp;
	}
}
