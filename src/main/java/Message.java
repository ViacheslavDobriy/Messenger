import java.time.LocalDate;

/**
 * описываем объект сообщение
 */
public class Message {
    Person person;
    String message;
    LocalDate date;

    public Message(Person person, String message, LocalDate date) {
        this.person = person;
        this.message = message;
        this.date = date;
    }
}
