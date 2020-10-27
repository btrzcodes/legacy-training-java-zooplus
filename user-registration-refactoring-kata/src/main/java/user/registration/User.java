package user.registration;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public User() {
        super();
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public MyEmail generateConfirmationEmail() {
        return new MyEmail(this.email,"noreply@codium.team","Welcome to Codium","This is the confirmation email");
    }
}
