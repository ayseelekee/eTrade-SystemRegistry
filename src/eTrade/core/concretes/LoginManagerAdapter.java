package eTrade.core.concretes;

import eTrade.core.abstracts.LoginService;

public class LoginManagerAdapter implements LoginService{

	@Override
	public void log(String message) {
		System.out.println("E-Mail sent: "+message);
		
	}

	@Override
	public boolean emailVerification(String email) {
		return true;
	}

}
