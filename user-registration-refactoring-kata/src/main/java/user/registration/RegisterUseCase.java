package user.registration;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class RegisterUseCase {
	public RegisterUseCase() {
	}

	User generateUser(String password, String email, String name)
			throws MessagingException, InvalidPasswordException, InvalidEmailException {
		if (password.length() <= 8 || !password.contains("_")) {
			throw new InvalidPasswordException();
		}

		if (UserRegistrationController.orm.findByEmail(email) != null) {
			throw new InvalidEmailException();
		}

		User user = new User(new Random().nextInt(), name, email, password);
		UserRegistrationController.orm.save(user);

		Properties prop = new Properties();
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("smtpUsername", "smtpPassword");
			}
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("noreply@codium.team"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject("Welcome to Codium");
		String msg = "This is the confirmation email";
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		message.setContent(multipart);
		// If a proper SMTP server is configured, this line could be uncommented
		// Transport.send(message);

		return user;
	}
}