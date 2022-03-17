package eTrade.business.concretes;

import java.util.List;

import eTrade.business.abstracts.UserService;
import eTrade.entities.concretes.User;
import eTrade.core.concretes.LoginManagerAdapter;
import eTrade.core.concretes.EmailVerificationManagerAdapter;
import eTrade.core.abstracts.LoginService;
import eTrade.dataAccess.abstracts.UserDao;

public class UserManager implements UserService {
	private UserDao userDao;
	private LoginService loginService;

	
	public UserManager(UserDao userDao, LoginService loginService) {
		this.userDao = userDao;
		this.loginService = loginService;
	}

	@Override
	public void add(User user) {
		if (userInformationIsEmpty(user) && userCharacterLength(user) && userIsRegistered(user)
				&& emailVerificationControl(user.getEmail())) {
			loginService.log("Dogrulama e-postasi gonderildi. Lutfen dogrulayin.");
			if (loginService.emailVerification(user.getEmail())) {
				loginService.log("Sisteme basariyla kaydedildi");
				userDao.add(user);
			} else {
				loginService.log("Kayit basarisiz");

			}
		}
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void login(String email, String password) {
		boolean check = false;
		for (User user : userDao.getAll()) {
			if (user.getEmail() == email && user.getPassword() == password) {
				check = true;
				break;
			}
		}
		if (check) {
			System.out.println("Sisteme giris yapildi. E-posta ve Sifre eslestirildi");
		} else {
			System.out.println("E-posta veya sifre yanlis");
		}
		
	}
	
	boolean userInformationIsEmpty(User user) {
		if (!user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		} else {
			System.out.println("Lütfen e-posta ve sifreyi doldurun");
			return false;
		}
	}

	boolean userCharacterLength(User user) {
		if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2 && user.getPassword().length() >= 6) {
			return true;
		} else {
			System.out.println("Ad ve Soyad en az 2 karakter olmalidir. Sifre en az 6 karakter olmalidir");
			return false;
		}
	}

	boolean userIsRegistered(User user) {
		boolean control = false;
		for (User userCounter : userDao.getAll()) {
			if (userCounter.getEmail() == user.getEmail()) {
				control = true;
			}
		}

		if (control) {
			System.out.println("E-posta daha once kullanildi");
			return false;
		} else {
			return true;
		}

	}

	boolean emailVerificationControl(String email) {
		EmailVerificationManagerAdapter emailVerificationManagerAdapter = new EmailVerificationManagerAdapter();
		LoginManagerAdapter loginManagerAdapter = new LoginManagerAdapter();
		boolean verificationTool = emailVerificationManagerAdapter.emailIsValid(email);
		boolean loginTool = loginManagerAdapter.emailVerification(email);

		if (loginTool == true && verificationTool) {
			System.out.println("dogrulama basarili");
			return true;
		} else {
			System.out.println("dogrulama basarisiz");
			return false;
		}
	}

}
