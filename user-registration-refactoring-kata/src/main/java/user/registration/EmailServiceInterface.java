package user.registration;

import javax.mail.MessagingException;

public interface EmailServiceInterface {
    public void sendConfirmationEmail(String from, String to, String content, String subject) throws SendEmailException;
}
