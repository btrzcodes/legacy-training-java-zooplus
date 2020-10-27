package user.registration;


public class Email {

    public void createEmail (EmailSender sender, String email) throws EmailException {
        String subject = "Welcome to Codium";
        String msg = "";
        sender.sendEmail(email, subject, msg);
    }

}
