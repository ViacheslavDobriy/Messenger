import java.util.Scanner;

/**
 * Описываем администратора
 */
public class Admin extends Person implements AdminActions{

    public Admin(String name, String surname) {
        super(name, surname);
        login = "Admin";
        password = "Admin";
    }

    @Override
    public void removeUserFromChat(Person person) {

    }

    @Override
    public void addUserInChat(Person person, Chat chat) {

        chat.getUsers().add(person);

    }

    @Override
    public void giveRole(Person person) {
        System.out.println("Which role you wanna give him?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("Moder")) {
            person.role = Role.MODERATOR;
        } else {
            System.out.println("To be continued");
        }

    }

    @Override
    public void removeMessage() {

    }

    @Override
    public void banUser(Person user) {

    }

    @Override
    public void editMessage() {

    }
}
