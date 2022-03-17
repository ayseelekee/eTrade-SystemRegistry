package eTrade.core.concretes;

import eTrade.core.abstracts.VerificationService;
import eTrade.email.EmailVerificationManager;


public class EmailVerificationManagerAdapter implements VerificationService{

	@Override
	public boolean emailIsValid(String email) {
		 EmailVerificationManager emailVerificationManager = new  EmailVerificationManager();
		return emailVerificationManager.emailVerification(email);
	}

}
