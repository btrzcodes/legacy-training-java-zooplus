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
	public UserRegistration userRegistrator = new UserRegistration();
	public EmailSender emailService = new ImplEmailSender();

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(HttpServletRequest request) throws MessagingException {

		User user;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			user = userRegistrator.register(orm, name, email, password);
			emailService.sendEmail(email);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(user);
	}
}
