package user.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRegistrationController {

    public static Repository<User> orm = new UserOrmRepository();
    public static EmailServiceInterface emailService = new EmailService();

    @PostMapping("/users")
    public static ResponseEntity createUser(HttpServletRequest request) {

        InsertUserService ius = new InsertUserService(orm, emailService);

        try {
            String userName = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = ius.insertUser(userName, email, password);

            return ResponseEntity.ok(user);

        } catch ( InvalidPasswordException | DuplicatedEmailException ipe){
            return new ResponseEntity(ipe.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (SendEmailException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
