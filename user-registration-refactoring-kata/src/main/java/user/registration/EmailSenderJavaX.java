package user.registration;

import user.registration.exceptions.EmailException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailSenderJavaX implements EmailSender {

    private Properties prop = new Properties();
    private Session session = Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("smtpUsername", "smtpPassword");
        }
    });

    public void sendConfirmationEmail(MyEmail myEmail) throws EmailException {

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myEmail.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(myEmail.getTo()));
            message.setSubject(myEmail.getSubject());
            String msg = myEmail.getMessage();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
        } catch (MessagingException e) {
            throw new EmailException(e.getMessage());
        }
        // If a proper SMTP server is configured, this line could be uncommented
        // Transport.send(message);
    }
}
