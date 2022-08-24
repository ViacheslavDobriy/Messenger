/**
 * Описываем администратора
 */
public class Admin extends Person{

    public Admin(String name, String surname) {
        super(name, surname);
        setRole();
    }

    @Override
    public void setRole() {
        role = Role.ADMIN;
    }
}
