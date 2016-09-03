package com.example.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Purpose: Checks for admin status of user
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class CurrentAuth {
	
public static void currentAuth(StringBuilder sb){
		
		//Gets authentication status of user in the session
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String authenticationTest = "[ROLE_ADMIN]";
		
		//checks for admin status
		if(authenticationTest.equals(auth.getAuthorities().toString())){
			sb.append("ROLE_ADMIN");
		}
	}
}
