package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Purpose: Provides path to login page
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

@Controller
public class LoginController {
	

	
	@RequestMapping("/login")
	public ModelAndView login(ModelMap model, HttpSession session,
			@RequestParam(value="error", required=false)String error) { 

		//Show error in a failed login attempt
		if(error != null){
			session.setAttribute("error", "Invalid username and password!");
		}
		
		return new ModelAndView("login", "model", model);
	}
	
}
