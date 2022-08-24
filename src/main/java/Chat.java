import java.util.ArrayList;
import java.util.List;

/**
 * Описываю класс Chat
 */
public class Chat {
    List<Person> users = new ArrayList<>();
    List<Message> messagesData = new ArrayList<>();

    public Chat(Person user) {
        this.users.add(user);
    }

}
