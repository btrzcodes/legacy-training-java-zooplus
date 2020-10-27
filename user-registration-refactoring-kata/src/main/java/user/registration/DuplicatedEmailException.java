package user.registration;

public class DuplicatedEmailException extends Exception {
    public DuplicatedEmailException(String message) {
        super(message);
    }
}
