/**
 * Описываем абстрактный класс личность
 */
public abstract class Person {
    String name;
    String surname;
    Role role;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract void setRole();
}
