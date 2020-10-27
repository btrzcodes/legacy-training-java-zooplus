package user.registration;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class RegisterUseCase {
	public UserOrmRepository orm = new UserOrmRepository();

	public RegisterUseCase() {
	}

	User generateUser(String password, String email, String name)
			throws MessagingException, InvalidPasswordException, InvalidEmailException {
		validatePassword(password);
		validateEmail(email);
		User user = buildUser(password, email, name);
		// WTF!!!
		orm.save(user);

		sendSMTPMessage(email);

		return user;
	}

	private void sendSMTPMessage(String email) throws MessagingException, AddressException {
		Session session = createSMTPSession();
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
	}

	private Session createSMTPSession() {
		Session session = Session.getInstance(new Properties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("smtpUsername", "smtpPassword");
			}
		});
		return session;
	}

	private User buildUser(String password, String email, String name) {
		User user = new User(new Random().nextInt(), name, email, password);
		return user;
	}

	private void validateEmail(String email) throws InvalidEmailException {
		if (UserRegistrationController.orm.findByEmail(email) != null) {
			throw new InvalidEmailException();
		}
	}

	private void validatePassword(String password) throws InvalidPasswordException {
		if (password.length() <= 8 || !password.contains("_")) {
			throw new InvalidPasswordException();
		}
	}
}