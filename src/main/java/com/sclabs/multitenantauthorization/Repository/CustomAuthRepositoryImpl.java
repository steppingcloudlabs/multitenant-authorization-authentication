package com.sclabs.multitenantauthorization.Repository;

import com.sclabs.multitenantauthorization.Model.Users;

public class CustomAuthRepositoryImpl implements CustomAuthRepository{

	public CustomAuthRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users login(String username, String password, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users privateLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users Signup(String username, String email, String passowrd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users Signup(String username, String email, String passowrd, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users privateSignup(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String accessKey(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
