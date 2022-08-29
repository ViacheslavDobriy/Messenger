import java.util.ArrayList;
import java.util.List;

/**
 * Описываю класс Chat, храню здесь только участников чата и сообщения, которые были введены в данном чате.
 * На данный момент реализовано общение только двух пользователей.
 * Общение двух+ пользователей работает с ошибкой.
 * Групповые чаты будут добавлены в следующем обновлении.
 */
public class Chat {
    private Person person1;
    private Person person2;
    private List<Message> messagesData = new ArrayList<>();

    public Chat(Person person) {
        this.person1=person;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public List<Message> getMessagesData() {
        return messagesData;
    }
}
