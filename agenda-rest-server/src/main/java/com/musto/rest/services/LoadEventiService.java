package com.musto.rest.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.musto.rest.db.DBConnection;
import com.musto.rest.model.Evento;

@Service("LoadEventiService")
public class LoadEventiService {
	
	public ArrayList<Evento> getEventi(String user, String pwd, String categoria) throws Exception {
		DBConnection db = new DBConnection();
    	if (db.openConnection())
    		System.out.println("connessione con il db ok per load");
    	else
    		return null;	
    	ArrayList<Evento> list = new ArrayList<Evento>();
  
    	list = db.getEventList(categoria);
    	return list;
	}
}
