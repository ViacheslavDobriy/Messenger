import java.util.ArrayList;
import java.util.List;

/**
 * Описываю класс Chat, храню здесь только участников чата и сообщения, которые были введены в данном чате
 */
public class Chat {
    private List<Person> users = new ArrayList<>();
    private List<Message> messagesData = new ArrayList<>();

    public Chat(Person person) {;
        this.users.add(person);
    }

    public List<Person> getUsers() {
        return users;
    }

    public List<Message> getMessagesData() {
        return messagesData;
    }
}
