package eTrade.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.UserDao;
import eTrade.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users;
	

	public HibernateUserDao() {
		users = new ArrayList<User>();
	}
	
	
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullanici eklendi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("Kullanici silindi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanici guncellendi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
