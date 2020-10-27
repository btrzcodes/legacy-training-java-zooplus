package user.registration;

import user.registration.exceptions.EmailException;

public interface EmailSender {
    public void sendConfirmationEmail(MyEmail email) throws EmailException;
}
