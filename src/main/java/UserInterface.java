import java.util.Scanner;

/**
 * Описываю как проходит верификация и здесь же основное меню, буду в будущем это дело разделять
 */
public class UserInterface {
    private Scanner insert = new Scanner(System.in);

    public void hello() {
        System.out.println("*****************Welcome to the SlavaMes******************");
        System.out.println("*****This is new messenger from Junior Java-developer*****");
        System.out.println("Insert your login/name");
        String login = insert.nextLine();
        for (ID id: MemberStorage.getIdStorage()) {
            if (login.equals(id.getPerson().login)){
                System.out.println("Insert your password");
                while (!insert.nextLine().equals(id.getPerson().password)){
                    System.out.println("password is incorrect! Try again!");
                }
                System.out.println("You are successfully log in");
                mainMenu(id.getPerson());
            }
        }
        System.out.println("We can't find you, do you wanna register?");
        if(insert.nextLine().equals("yes")){
            mainMenu(registration());
        } else System.out.println("See you next time!");
    }

    public Person registration(){
        System.out.println("Insert your name: ");
        String name = insert.nextLine();
        System.out.println("Insert your surname: ");
        String surname = insert.nextLine();
        return new User(name, surname);
    }

    public void mainMenu(Person person) {
        System.out.println("*****Congratulation with your registration on SlavaMes!*****");
        System.out.println("Do you wanna add friend in your friend list?*****************");
        while (insert.nextLine().equals("yes")){
            person.getContactList().add(((User) person).addPersonInFriends());
            System.out.println("If you wanna continue type yes, if you wanna see list of your friends type no");
        }
        for (Person friend: person.getContactList()) {
            System.out.printf("%s %s\n", friend.name, friend.surname);
        }
        System.out.println("Type name of your friend to chat with him!");
        for (Person friend: person.getContactList()) {
            if(friend.name.equals(insert.nextLine())) {

            }
        }
    }
}
