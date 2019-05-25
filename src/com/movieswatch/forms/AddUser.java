package com.movieswatch.forms;

import javax.servlet.http.HttpServletRequest;

import com.movieswatch.model.Test;
import com.movieswatch.query.EntityFinderImpl;



public class AddUser {
	
	EntityFinderImpl<Test> entityFinderImplUser = new EntityFinderImpl<>();
	Test user= new Test();
	
	public Test addUserInDataBase(HttpServletRequest request) {
		
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		
		user.setNom(nom);
		user.setEmail(email);
		
		entityFinderImplUser.insert(user);
		
		return user;
	}

}
