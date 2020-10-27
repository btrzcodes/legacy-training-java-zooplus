package user.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRegistrationController {
    public static UserOrmRepository orm = new UserOrmRepository();
    private final RegisterUseCase registerUseCase = new RegisterUseCase();
    
    private String name;
    private String password;
    private String email;

    @PostMapping("/users")
    public ResponseEntity createUser(HttpServletRequest request) throws MessagingException {

        return registerUseCase.generateUser(
                request.getParameter("password"), 
                request.getParameter("email"), 
                request.getParameter("name")
        );
    }
    
}
