/**
 * Описываем абстрактный класс личность
 */
public abstract class Person {
    String name;
    String surname;
    Role role;
    String login;
    String password;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Chat startChat(Person person){
        person.role = Role.ADMIN;
        return new Chat(person);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}