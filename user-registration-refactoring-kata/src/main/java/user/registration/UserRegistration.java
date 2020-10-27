package user.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

public class UserRegistration {

    public boolean isInvalidPassword(String password) {
        return password.length() <= 8 || !password.contains("_");
    }

    public boolean isInvalidEmail(User user) {
        return user != null;
    }

    private void validate(UserOrmRepository orm, HttpServletRequest request) throws Exception {
        if (isInvalidPassword(request.getParameter("password"))) {
            throw new Exception("The password is not valid");
        }

        if (isInvalidEmail(orm.findByEmail(request.getParameter("email")))) {
            throw new Exception("The email is already in use");
        }
    }

    public User register(UserOrmRepository orm, HttpServletRequest request) throws Exception {

        validate(orm, request);

        User user = new User(
                new Random().nextInt(),
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("password")
        );
        orm.save(user);

        return user;
    }

}
