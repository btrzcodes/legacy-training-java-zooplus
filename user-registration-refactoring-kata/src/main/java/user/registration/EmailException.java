package user.registration;

import javax.mail.MessagingException;

public class EmailException extends Exception {
    public EmailException(MessagingException e) {
        super(e);
    }
}
