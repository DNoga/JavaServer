package com.example.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Purpose: Provides path to logout page
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) { 

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		//nullifies authentication in the session
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("logout");
	}
}
