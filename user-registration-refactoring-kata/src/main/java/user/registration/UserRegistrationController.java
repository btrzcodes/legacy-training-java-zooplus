package user.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRegistrationController {
    public static UserOrmRepository orm = new UserOrmRepository();
    public UserRegistration validator = new UserRegistration();

    @PostMapping("/users")
    public ResponseEntity createUser(HttpServletRequest request) {

        User user;

        try {
            String email = request.getParameter("email");
            user = validator
                    .register(orm, request.getParameter("name"),
                    request.getParameter("password"),
                            email);

            new JavaXMail().sendEmail( new Email (email, "Welcome to Codium", "") );
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(user);
    }
}
