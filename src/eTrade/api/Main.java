package eTrade.api;

import eTrade.business.concretes.UserManager;
import eTrade.core.concretes.LoginManagerAdapter;
import eTrade.dataAccess.concretes.HibernateUserDao;
import eTrade.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user=new User(1,"Ayse","Leke","ayse.leke@outlook.com","abcabc");
		
		UserManager userManager = new UserManager(new HibernateUserDao(),new LoginManagerAdapter());
		userManager.add(user);
		userManager.login("ayse.leke@outlook.com", "abcabc");
		
		
		
		System.out.println("------------------------------------------------------");
		
		
		
		User user1=new User(2,"Betul","Ince","betul.ince@outlook.com","abc");
		
		UserManager userManager1 = new UserManager(new HibernateUserDao(),new LoginManagerAdapter());
		userManager1.add(user1);
		userManager1.login("betul.ince@outlook.com", "abc");

	}

}
