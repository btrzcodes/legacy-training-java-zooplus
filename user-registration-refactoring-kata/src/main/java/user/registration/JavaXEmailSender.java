package user.registration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class JavaXEmailSender implements EmailSender {

    public void send(Email email) throws EmailException {
        try {

            Properties prop = new Properties();
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("smtpUsername", "smtpPassword");
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
            message.setSubject(email.getSubject());
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(email.getBody(), "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            // If a proper SMTP server is configured, this line could be uncommented
            // Transport.send(message);
        } catch (MessagingException e) {
            throw new EmailException();
        }
    }
}