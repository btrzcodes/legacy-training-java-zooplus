package user.registration;

import java.util.Random;

public class InsertUserService {

    private Repository<User> orm;
    private EmailServiceInterface emailService;

    public InsertUserService(Repository<User> orm, EmailServiceInterface emailService) {
        this.orm = orm;
        this.emailService = emailService;
    }

    public User insertUser(String userName, String email, String password) throws DuplicatedEmailException, InvalidPasswordException, SendEmailException {
        validateEmail(email);
        validatePassword(password);
        User user = new User(
                new Random().nextInt(),
                userName,
                email,
                password
        );
        orm.save(user);

        emailService.sendConfirmationEmail("noreply@codium.team", email, "This is the confirmation email", "Welcome to Codium");

        return user;
    }

    private void validateEmail(String email) throws DuplicatedEmailException {
        if (orm.findByEmail(email) != null) {
            throw new DuplicatedEmailException("The email is already in use");
        }
    }

    private void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() <= 8 || !password.contains("_")) {
            throw new InvalidPasswordException("The password is not valid");
        }
    }
}
