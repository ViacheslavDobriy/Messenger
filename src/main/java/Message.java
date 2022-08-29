import java.time.LocalDate;

/**
 * описываем объект сообщение
 * В одном из следующих обновлений будет добавлена хронология сообщений
 */
public class Message {
    Person person;
    String message;
//    LocalDate date;

    public Message(Person person, String message) {
        this.person = person;
        this.message = message;
//        this.date = date;
    }
}
