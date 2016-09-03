package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Purpose: Provides path to index
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

//Redirects to login page if not signed in
@Controller
public class IndexController {
	@RequestMapping("/index")
	public ModelAndView index() {
 
		return new ModelAndView("index");
	}
}
