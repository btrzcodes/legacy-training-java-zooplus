package user.registration;

public interface EmailSender {
    void sendEmail(Email email) throws EmailException;
}
