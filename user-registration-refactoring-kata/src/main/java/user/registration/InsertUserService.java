package user.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

public class InsertUserService {
    private UserOrmRepository orm;
    public InsertUserService(UserOrmRepository orm) {
        this.orm = orm;
    }

    public User insertUser(HttpServletRequest request) throws IllegalArgumentException{
        validateEmail(request);
        validatePassword(request);
        User user = new User(
                new Random().nextInt(),
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("password")
        );
        orm.save(user);
        return user;
    }

    private void validateEmail(HttpServletRequest request) throws IllegalArgumentException{
        if (orm.findByEmail(request.getParameter("email")) != null) {
            throw new IllegalArgumentException("The email is already in use");
          //  return new ResponseEntity("The email is already in use", HttpStatus.BAD_REQUEST);
        }
    }

    private void validatePassword(HttpServletRequest request) throws IllegalArgumentException{
        if (request.getParameter("password").length() <= 8 || !request.getParameter("password").contains("_")) {
            throw new IllegalArgumentException("The password is not valid");
        }
    }
}
