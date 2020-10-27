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

    private String validate(UserOrmRepository orm, HttpServletRequest request) {
        if (isInvalidPassword(request.getParameter("password"))) {
            return "The password is not valid";
        }

        if (isInvalidEmail(orm.findByEmail(request.getParameter("email")))) {
            return "The email is already in use";
        }

        return "";

    }

    public User register(UserOrmRepository orm, HttpServletRequest request) throws Exception {

        String error = validate(orm, request);
        if(!error.isEmpty())
            throw new Exception(error);

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
