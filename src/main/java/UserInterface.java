import java.io.IOException;
import java.util.Scanner;

/**
 * Описываю как проходит верификация и здесь же основное меню, буду в будущем это дело разделять
 */
public class UserInterface {
    private Scanner insert = new Scanner(System.in);

    public void hello() throws IOException {
        System.out.println("*****************Welcome to the SlavaMes******************");
        System.out.println("*****This is new messenger from Junior Java-developer*****");
        MemberStorage.checkUsersDB();
        enterInSystem();
        System.out.println("We can't find you, do you wanna register?");
        if(insert.nextLine().equals("yes")){
            mainMenu(registration());
        } else System.out.println("See you next time!");
    }

    public Person registration() throws IOException {
        System.out.println("Insert your name: ");
        String name = insert.nextLine();
        System.out.println("Insert your surname: ");
        String surname = insert.nextLine();
        Person newUser = new User(name, surname);
        MemberStorage.addUserInFile(newUser);
        System.out.println("*****Congratulation with your registration on SlavaMes!*****");
        System.out.println("Do you wanna add friend in your friend list?*****************");
        return newUser;
    }

    public void enterInSystem() throws IOException {
        System.out.println("Insert your name");
        String login = insert.nextLine();
        for (ID id: MemberStorage.getIdStorage()) {
            if (login.equals(id.getPerson().name)){
                System.out.println("Insert your password");
                while (!insert.nextLine().equals(id.getPerson().password)){
                    System.out.println("password is incorrect! Try again!");
                }
                System.out.println("You are successfully log in");
                id.getPerson().addInFriendsFromFile();
                if (id.getPerson().contactList != null) {
                    id.getPerson().showFriends();
                }
                System.out.println("Do you wanna add friend in your friend list?*****************");
                mainMenu(id.getPerson());
            }
        }
    }

    public void mainMenu(Person person) throws IOException {
        while (insert.nextLine().equals("yes")){
            person.getContactList().add(((User) person).addPersonInFriends());
            person.updateFriendListFile();
            System.out.println("If you wanna continue type yes, if you wanna see list of your friends type no");
        }
        for (Person friend: person.getContactList()) {
            System.out.printf("%s %s\n", friend.name, friend.surname);
        }
        System.out.println("Type name of your friend to chat with him!");
        String name = insert.nextLine();
        for (Person friend: person.getContactList()) {
            if(friend.name.equals(name)) {
                chatting(new Chat(person, friend));
            }
        }
    }

    private void chatting(Chat chat) throws IOException {
        System.out.println("Write '/stop' when you want stop your chatting");
        String message = "NoSTOP";
        while(!message.equals("/stop")){
            System.out.println(chat.getPerson1().name);
            message = insert.nextLine();
            if(!message.equals("/stop")) {
                chat.getMessagesData().add(new Message(chat.getPerson1(), message));
                System.out.println(chat.getPerson2().name);
                message = insert.nextLine();
                if(!message.equals("/stop")) {
                    chat.getMessagesData().add(new Message(chat.getPerson2(), message));
                }
            }
        }
        chat.writeMessageInFile();
    }
}
