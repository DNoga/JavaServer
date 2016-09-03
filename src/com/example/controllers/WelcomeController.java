package com.example.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.auth.CurrentAuth;

/**
 * Purpose: Provides path to the welcome page
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

@Controller
public class WelcomeController {
	

	@RequestMapping("/member/welcome")
	public ModelAndView welcome(ModelMap model, HttpSession session,Principal principal) {
		
		
		StringBuilder sb = new StringBuilder();
		String name = principal.getName();
		
		CurrentAuth.currentAuth(sb);
		
		//Sets the user's authentication in the session
		//used for front-end admin access
		session.setAttribute("authenticate", sb);
		//Sets the username in the front-end
		session.setAttribute("userName", name);
		
		return new ModelAndView("welcome", "model", model);
	}

	
}
