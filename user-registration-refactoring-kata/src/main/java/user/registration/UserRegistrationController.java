package user.registration;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {
	public static UserOrmRepository orm = new UserOrmRepository();
	private final RegisterUseCase registerUseCase = new RegisterUseCase();

	@PostMapping("/users")
	public ResponseEntity createUser(HttpServletRequest request) throws MessagingException {
		try {
			User user = registerUseCase.generateUser(request.getParameter("password"), request.getParameter("email"),
					request.getParameter("name"));
			return ResponseEntity.ok(user);
		} catch (InvalidPasswordException e) {
			return new ResponseEntity("The password is not valid", HttpStatus.BAD_REQUEST);
		} catch (InvalidEmailException e) {
			return new ResponseEntity("The email is already in use", HttpStatus.BAD_REQUEST);
		}

	}

}
