import java.util.ArrayList;
import java.util.List;

/**
 * Описываем абстрактный класс личность
 */
public abstract class Person {
    protected String name;
    protected String surname;
    protected Role role;
    protected String login;
    protected String password;
    protected List<Person> contactList = new ArrayList<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public void setID(){
        new ID(this);
    }

    public List<Person> getContactList() {
        return contactList;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
