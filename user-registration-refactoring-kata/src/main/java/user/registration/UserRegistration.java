package user.registration;

import java.util.Random;

public class UserRegistration {

	private boolean isInvalidPassword(String password) {
		return password.length() <= 8 || !password.contains("_");
	}

	private boolean isInvalidEmail(User user) {
		return user != null;
	}

	private void validate(UserOrmRepository orm, String password, String email) throws Exception {
		if (isInvalidPassword(password)) {
			throw new Exception("The password is not valid");
		}

		if (isInvalidEmail(orm.findByEmail(email))) {
			throw new Exception("The email is already in use");
		}
	}

	public User register(UserOrmRepository orm, String name, String email, String password) throws Exception {
		validate(orm, password, email);
		User user = buildUser(name, email, password);
		orm.save(user);
		return user;
	}

	private User buildUser(String name, String email, String password) {
		User user = new User(new Random().nextInt(), name, email, password);
		return user;
	}

}
