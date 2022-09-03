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

    public default Person addPersonInFriends(){
        Scanner nameSurname = new Scanner(System.in);
        System.out.println("Insert name of your friend: ");
        String name = nameSurname.nextLine();
        for (ID id: MemberStorage.getIdStorage()) {
            if (name.equals(id.getPerson().name)) {
                System.out.println("Insert surname of your friend: ");
                String surname = nameSurname.nextLine();
                if (surname.equals(id.getPerson().surname)) {
                    return id.getPerson();
                } else System.out.println("We don't have this person in our DataBase");
            }
        }
        System.out.println("We didn't found this person in our DataBase!");
        return null;
    }

//    public default addFriendInFile() {
//
//    }

    public void editMessage();
}
