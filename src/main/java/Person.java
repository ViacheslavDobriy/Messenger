import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Описываю абстрактный класс личность
 */
public abstract class Person {
    protected String name;
    protected String surname;
    protected Role role;
    protected String login;
    protected String password;
    protected List<Person> contactList = new ArrayList<>();

    protected static Path path = Path.of("C:\\Users\\user\\Desktop\\GeekBrains\\Java\\Messenger\\myContacts.txt");

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public List<Person> getContactList() {
        return contactList;
    }

    public void addInFriendsFromFile() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(Path.of(String.valueOf(path)));
        } else {
            List<String> readedList = Files.readAllLines(path);
            for (String person : readedList) {
                String[] nameSurname = person.split(" ");
                getContactList().add(new User(nameSurname[0], nameSurname[1]));
            }
        }
    }

    public void updateFriendListFile() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(Path.of(String.valueOf(path)));
        } else {
            String allFriends = "";
            for (Person friend: contactList) {
                allFriends += friend.name + " " + friend.surname + "\n";
            }
            Files.writeString(path, allFriends);
            System.out.println("Written in file with friends!");
        }
    }

    public void showFriends() {
        for (Person friend: contactList) {
            System.out.println(friend.name + " " + friend.surname);
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
