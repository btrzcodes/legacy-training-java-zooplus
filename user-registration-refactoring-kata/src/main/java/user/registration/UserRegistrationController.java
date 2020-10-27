package user.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;
import java.util.Random;


@RestController
public class UserRegistrationController {
    @PostMapping("/users")
    public ResponseEntity createUser(HttpServletRequest request){
        userRegistrationService userRegistration = new userRegistrationService();
        try{
            String password = request.getParameter("password");
            String email= request.getParameter("email");
            String name= request.getParameter("name");
            return userRegistration.createUser(password,email,name);
        } catch(MessagingException error) {
            return error;
        } catch (InvalidPasswordException error) {
            return new ResponseEntity("The password is not valid", HttpStatus.BAD_REQUEST);
        } catch (InvalidEmailException error) {
            return new ResponseEntity("The email is already in use", HttpStatus.BAD_REQUEST);
        }
    }
}
