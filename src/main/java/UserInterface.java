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
        System.out.println("You aren't registered yet, do you wanna register?");
        if(insert.nextLine().equals("yes")){
            System.out.println("Insert your name: ");
            String name = insert.nextLine();
            System.out.println("Insert your surname: ");
            String surname = insert.nextLine();
            Person newUser = new User(name, surname);
            usersData.getUsersData().add(newUser);
            mainMenu(newUser);
        } else System.out.println("See you next time!");
    }

    public void mainMenu(Person person) {
        System.out.println("Do you wanna chat?");
        if(insert.nextLine().equals("yes")){
            Chat chat = person.startChat(person);
            adminMenu(chat);
        } else {
            System.out.println("Ok! bye bye!");
        }
    }

    public void adminMenu(Chat chat) {
        menu();
        int choice = insert.nextInt();
        while(choice<4) {
            switch (choice) {
                case 1 -> {
                    System.out.println("Insert name of your friend: ");
                    String name = insert.nextLine();
                    System.out.println("Insert surname of your friend: ");
                    String surname = insert.nextLine();
                    User newUser = new User(name, surname);
                    ((Admin) chat.getUsers().get(0)).addUserInChat(newUser, chat);
                    menu();
                    choice = insert.nextInt();
                }
                case 2 -> {
                    System.out.println("Write STOP if you wanna stop conversation");
                    while (!insert.nextLine().equals("STOP")) {
                        for (Person man : chat.getUsers()) {
                            ((Admin) man).writeMessage(chat, man);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Who will get new role?");
                    for (Person man : chat.getUsers()) {
                        System.out.println(man.getLogin());
                    }
                    String inserted = insert.nextLine();
                    for (Person man : chat.getUsers()) {
                        if (man.getLogin().equals(inserted)) {
                            ((Admin) chat.getUsers().get(0)).giveRole(man);
                            System.out.println("Role is given");
                        }
                    }
                    menu();
                    choice = insert.nextInt();
                }
            }
        }
    }
    public void menu(){
        System.out.println("What do you wanna do?");
        System.out.println("1 - add member");
        System.out.println("2 - chat");
        System.out.println("3 - give a role to member");
    }
}
