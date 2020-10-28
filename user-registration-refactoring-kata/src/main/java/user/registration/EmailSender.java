package user.registration;

public interface EmailSender {
    void send(Email email) throws EmailException;
}
