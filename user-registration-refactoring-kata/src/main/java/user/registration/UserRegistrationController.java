package user.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRegistrationController {
    public static UserOrmRepository orm = new UserOrmRepository();
    public UserRegistration userRegistrator = new UserRegistration();

    @PostMapping("/users")
    public ResponseEntity createUser(HttpServletRequest request) throws MessagingException {

        User user;


        try {
            user = userRegistrator.register(orm, request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
            new Email().createEmail(request.getParameter("email"));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(user);
    }
}
