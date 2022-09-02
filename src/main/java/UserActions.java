import java.io.IOException;
import java.util.Scanner;

/**
 * Описываю интерфейс, что может делать обычный пользователь в мессенджере
 */
public interface UserActions {

    public default void writeMessage(Chat chat, Person person){
        Scanner scanner = new Scanner(System.in);
        System.out.println(person.name);
        chat.getMessagesData().add(new Message(person, scanner.nextLine()));
    }

    public default Person addPersonInFriends() throws IOException {
        Scanner nameSurname = new Scanner(System.in);
        System.out.println("Insert name of your friend: ");
        String name = nameSurname.nextLine();
        System.out.println("Insert surname of your friend: ");
        String surname = nameSurname.nextLine();
        Person newFriend = new User(name, surname);
        MemberStorage.addUserInFile(newFriend);
        return newFriend;

    }
    public void editMessage();
}
