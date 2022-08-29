/**
 * Описываем модератора
 */
public class Moderator extends Person implements ModeratorActions{

    public Moderator(String name, String surname) {
        super(name, surname);
        setID();
        login = "Moderator";
        password = "Moderator";
    }

    @Override
    public void editMessage() {

    }

    @Override
    public void removeMessage() {

    }

    @Override
    public void banUser(Person user) {

    }
}
