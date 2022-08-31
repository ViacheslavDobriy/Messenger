import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    private Path path = Path.of("C:\\Users\\user\\Desktop\\GeekBrains\\Java\\Messenger\\chats.txt");

    public Chat(Person person1, Person person2) throws IOException {
        this.person1=person1;
        this.person2=person2;
        if (!Files.exists(path)) {
            Files.createFile(Path.of(String.valueOf(path)));
        }
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

    public void writeMessageInFile() throws IOException {
        String allMessages = "";
        allMessages += Files.readString(path);
        for (Message message: messagesData) {
            allMessages += message.toString() + "\n";
        }
        Files.writeString(path, allMessages);
    }
}
