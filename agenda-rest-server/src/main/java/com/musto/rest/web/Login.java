package com.musto.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.musto.rest.services.LoginService;

@RestController
@RequestMapping(path = "rest/login")
public class Login {
	

	@Autowired
	LoginService loginService;   
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody String controlLogin(EventoResource resource) throws Exception {
		System.out.println("---> "+resource.toString());
		return loginService.loginService(resource.getUsername(), resource.getPassword());
		
	}
	
}
