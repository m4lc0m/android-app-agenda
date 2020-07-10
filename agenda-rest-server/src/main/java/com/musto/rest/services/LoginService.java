package com.musto.rest.services;

import org.springframework.stereotype.Service;

import com.musto.rest.db.DBConnection;

@Service("LoginService")
public class LoginService {
	
	 public String loginService (String user, String pwd) throws Exception {
	    	DBConnection db = new DBConnection();
	    	if (db.openConnection())
	    		System.out.println("connessione con il db ok");
	    	
	        System.out.println("LOGIN");
	        System.out.println("username inserito: "+user);
	        System.out.println("password inserita: "+pwd);
	        int control_login = db.controlLogin(user, pwd);
	        String resp = null;
	        if(control_login == 1){
	        	resp = "ok";
	        }else{
	        	resp = "no";
	        }
	        return resp;
	    }

}
