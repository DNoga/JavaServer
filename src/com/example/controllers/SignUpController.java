package com.example.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.DbGroupDAO;
import com.example.dao.DbUserDAO;
import com.example.domain.DbUserPojo;

/**
 * Purpose: Provides path to sign up page
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

@Controller
public class SignUpController {
	


@Autowired
private DbUserDAO userJDBCTemplate;

@Autowired 
private DbGroupDAO groupJDBCTemplate;

@Autowired
private DbUserDAO userDao;
    
	
		@RequestMapping("/signup")
		public ModelAndView login() { 
			
			return new ModelAndView("signup");
		}
		
		@RequestMapping(value = "/signup", method = RequestMethod.POST)
		public ModelAndView submitForm(ModelMap model, HttpSession session,
				@ModelAttribute("registerForm") DbUserPojo User,
				@RequestParam("password") String userPw,
				@RequestParam("userName") String userName){
			
			//Changes to the auto-increment in the database
			int newUser = 0;
			
			//Creates a new user in the database
			userJDBCTemplate.create(0, userPw, 1, userName);
			
			List<DbUserPojo> listUsers = userDao.listUsers();
			
			//Looks for the user ID that was just created
			for(int i = 0; i < listUsers.size(); i++){
				if(listUsers.get(i).getId()> newUser){
					newUser = listUsers.get(i).getId();
				}
					
			}
			
			//Set the user id (foreign key) and creates new Group entry in database
			groupJDBCTemplate.create(0, "ROLE_USER", newUser, 1);	
		
			
			
			
			
			return new ModelAndView("redirect:/login", "model", model);
		}
	
}