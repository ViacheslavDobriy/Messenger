/**
 * Описываем обычного пользователя
 */
public class User extends Person implements UserActions{

    public User(String name, String surname) {
        super(name, surname);
        login = "User";
        password = "User";
    }

    @Override
    public void editMessage() {

    }
}
