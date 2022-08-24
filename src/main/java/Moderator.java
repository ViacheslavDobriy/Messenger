/**
 * Описываем модератора
 */
public class Moderator extends Person{

    public Moderator(String name, String surname) {
        super(name, surname);
        setRole();
    }

    @Override
    public void setRole() {
        role = Role.MODERATOR;
    }
}
