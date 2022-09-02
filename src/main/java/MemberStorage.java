import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Здесь хранятся все ID членов мессенджера
 * Попробовать реализовать и вызвать не статический метод addPersonFromFile() в статическом методе checkUserDB()
 */
public class MemberStorage {
    private static final List<ID> idStorage = new ArrayList<>();
    private static Path path = Path.of("C:\\Users\\user\\Desktop\\GeekBrains\\Java\\Messenger\\usersDB.txt");
    static int count = 0;

    private MemberStorage() {}

    public static List<ID> getIdStorage(){
        return idStorage;
    }

    public static void checkUsersDB() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(Path.of(String.valueOf(path)));
        } else {
            List<String> readedList = Files.readAllLines(path);
            for (String person: readedList) {
                String[] nameSurname = person.split(" ");
                idStorage.add(new ID(new User(nameSurname[0], nameSurname[1])));
            }

        }
    }

    public static void addUserInFile(Person person) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(Path.of(String.valueOf(path)));
        }
        String updatedDB = Files.readString(path) + person.name + " " + person.surname + "\n";
        Files.writeString(path, updatedDB);
        System.out.println("Written in file!");
    }

//    private void addPersonFromFile() {
//
//    }
}
