package eTrade.core.abstracts;

public interface LoginService {
	void log(String message);
	boolean emailVerification(String email);
}
