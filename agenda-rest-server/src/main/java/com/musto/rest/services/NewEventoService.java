package com.musto.rest.services;

import org.springframework.stereotype.Service;
import com.musto.rest.db.DBConnection;
import com.musto.rest.model.Evento;


@Service("NewEventoService")
public class NewEventoService {
	
	public Evento addEvento(String user, String pwd, String categoria, Evento evento) throws Exception {
		 DBConnection db = new DBConnection();
	     if(db.openConnection())
	        	System.out.println("connessione con il db ok per add evento");
	     else
	    	 return null;
	     /*int controlLogin = db.controlLogin(user, pwd);
	     if(controlLogin == 1){
	    	 System.out.println("Control login ok");
	        int numero_id= db.getNumId(categoria);		        
		    evento.setId(numero_id+1);	  		    	
		    int res = db.addEvento(categoria, evento);
		    System.out.println("categoria: ----> "+categoria);
		    System.out.println("evento: "+evento.toString());
		    if(res==0)
		    	return new Evento(numero_id,"","","","","","");
	        return evento;
	     }
	     return null;
	     */
	     	int numero_id= db.getNumId(categoria);		        
		    evento.setId(numero_id+1);	  		    	
		    int res = db.addEvento(categoria, evento);
		    System.out.println("categoria: ----> "+categoria);
		    System.out.println("evento: "+evento.toString());
		    if(res==0)
		    	return new Evento(numero_id,"","","","","","");
	        return evento;
	}
	
}
