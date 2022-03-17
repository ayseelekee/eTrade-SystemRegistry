package eTrade.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVerificationManager {
	public boolean emailVerification(String outlook) {
		
		Pattern pattern = Pattern.compile(".@outlook.com");
																
		Matcher matcher = pattern.matcher(outlook); 
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}

}
}
