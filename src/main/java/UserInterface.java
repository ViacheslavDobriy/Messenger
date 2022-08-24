import java.util.Scanner;

/**
 * Описываю как проходит верификация и здесь же основное меню, буду в будущем это дело разделять
 */
public class UserInterface {
    private Scanner insert = new Scanner(System.in);
    private UsersData usersData = new UsersData();

    public void verification() {
        System.out.println("Insert your login/name");
        String login = insert.nextLine();
        for (Person person: usersData.getUsersData()) {
            if (login.equals(person.getLogin())){
                System.out.println("Insert your password");
                if (insert.nextLine().equals(person.getPassword())){
                    System.out.println("You are successfully log in");
                    mainMenu(person);
                } else {
                    System.out.println("password is incorrect!");
                }
            }
        }
        System.out.println("To be continue");
    }

    public void mainMenu(Person person) {
        System.out.println("Do you wanna chat?");
        if(insert.nextLine().equals("yes")){
            Chat chat = person.startChat(person);
            adminMenu(person, chat);
        } else {
            System.out.println("Ok! bye bye!");
        }
    }

    public void adminMenu(Person person, Chat chat) {
        System.out.println("What do you wanna do?");
        System.out.println("1 - add member");
        System.out.println("2 - chat");
        System.out.println("3 - give a role to member");
        switch (insert.nextInt()) {
            case 1 -> {
                User newUser = new User("Nikita", "Molodec");
                ((Admin) person).addUserInChat(newUser, chat);
            }
            case 2 -> {
                System.out.println("Write STOP if you wanna stop conversation");
                while(!insert.nextLine().equals("STOP")) {
                    for (Person man: chat.getUsers()) {
                        ((Admin) man).writeMessage(chat, man);
                    }
                }
            }
            case 3 -> {
                System.out.println("Who will get new role?");
                for (Person man: chat.getUsers()) {
                    System.out.println(man.getLogin());
                }
                String inserted = insert.nextLine();
                for (Person man: chat.getUsers()) {
                    if (man.getLogin().equals(inserted)) {
                        ((Admin) person).giveRole(man);
                    }
                }
            }
        }
    }
}
