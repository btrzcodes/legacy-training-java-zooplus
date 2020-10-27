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
    public static UserOrmRepository orm = new UserOrmRepository();

    @PostMapping("/users")
    public ResponseEntity createUser(HttpServletRequest request) throws MessagingException {

        InsertUserService ius = new InsertUserService(orm);
        try {
            User user = ius.insertUser(request);

            sendConfirmationEmail(request);

            return ResponseEntity.ok(user);
        } catch ( IllegalArgumentException iae){
            return new ResponseEntity(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private void sendConfirmationEmail(HttpServletRequest request) throws MessagingException {
        Properties prop = new Properties();
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smtpUsername", "smtpPassword");
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("noreply@codium.team"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getParameter("email")));
        message.setSubject("Welcome to Codium");
        String msg = "This is the confirmation email";
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        message.setContent(multipart);
        // If a proper SMTP server is configured, this line could be uncommented
        // Transport.send(message);
    }


}
