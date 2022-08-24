/**
 * Описываем обычного пользователя
 */
public class User extends Person{

    public User(String name, String surname) {
        super(name, surname);
        setRole();
    }

    @Override
    public void setRole() {
        role = Role.USER;
    }
}
