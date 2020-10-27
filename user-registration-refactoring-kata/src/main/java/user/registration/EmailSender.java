package user.registration;

public interface EmailSender {
    void sendEmail(String email, String subject, String msg) throws EmailException;
}
