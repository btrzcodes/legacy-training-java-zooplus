package user.registration;

import java.util.Random;

public class RegisterUser {
    private final EmailSender emailSender;

    public RegisterUser(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    User execute(String password, String emailAddress, String name) throws InvalidPasswordException, DuplicatedEmailException, EmailException {
        if (password.length() <= 8 || !password.contains("_")) {
            throw new InvalidPasswordException();

        }

        if (UserRegistrationController.orm.findByEmail(emailAddress) != null) {
            throw new DuplicatedEmailException();

        }

        User user = new User(
                new Random().nextInt(),
                name,
                emailAddress,
                password
        );
        UserRegistrationController.orm.save(user);

        Email email = new Email("noreply@codium.team", emailAddress, "Welcome to Codium", "This is the confirmation email");
        emailSender.send(email);

        return user;
    }
}