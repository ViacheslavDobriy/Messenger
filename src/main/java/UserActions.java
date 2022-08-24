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
    public void editMessage();
}
