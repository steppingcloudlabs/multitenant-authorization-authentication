package com.sclabs.multitenantauthorization.Repository;

import com.sclabs.multitenantauthorization.Model.Users;

public interface CustomAuthRepository {

//	LOGIN 
	
	Users login(String username, String password);

	Users login(String username, String password, String userId);

	Users privateLogin(String username, String password);

//	SIGNUP
	Users Signup(String username, String email, String passowrd);
	Users Signup(String username, String email, String passowrd, String userId);

	Users privateSignup(String username, String password);
	
	
//	Aux Methods
	
	String resetPassword(String email, String password);
	String forgotPassword(String email);
	String accessKey(String username);
	
	
}
