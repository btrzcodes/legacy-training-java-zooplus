package user.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRegistrationController {
    public static UserOrmRepository orm = new UserOrmRepository();

    @PostMapping("/users")
    public ResponseEntity createUser(HttpServletRequest request) {

        RegisterUser registerUser = new RegisterUser(new JavaXEmailSender());
        try {
            User user = registerUser.execute(request.getParameter("password"), request.getParameter("email"), request.getParameter("name"));
            return ResponseEntity.ok(user);
        } catch (InvalidPasswordException e) {
            return new ResponseEntity("The password is not valid", HttpStatus.BAD_REQUEST);
        } catch (DuplicatedEmailException e) {
            return new ResponseEntity("The email is already in use", HttpStatus.BAD_REQUEST);
        } catch (EmailException e) {
            return null;
        }
    }

}
