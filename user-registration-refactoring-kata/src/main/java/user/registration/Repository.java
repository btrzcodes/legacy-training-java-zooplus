package user.registration;

public interface Repository<E> {

    public void save(E user);

    public User findByEmail(String email);
}
