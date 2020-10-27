package user.registration;

import java.util.Random;

public class UserRegistration {

    public boolean isInvalidPassword(String password) {
        return password.length() <= 8 || !password.contains("_");
    }

    public boolean isInvalidEmail(User user) {
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

    public User register(UserOrmRepository orm, String name, String password, String email) throws Exception {

        validate(orm, password, email);

        User user = new User(
                new Random().nextInt(),
                name,
                email,
                password
        );
        orm.save(user);

        return user;
    }

}
