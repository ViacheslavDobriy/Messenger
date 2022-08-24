import java.util.ArrayList;
import java.util.List;

/**
 * Описываю всех пользователей мессенджера, в будущем уберу их из конструктора и буду добавлять по ходу верификации
 */
public class UsersData {
    private List<Person> usersData = new ArrayList<>();

    public UsersData() {
        this.usersData.add(new User("Slava", "Dobrov"));
        this.usersData.add(new Admin("Nastya", "Slavnaya"));
        this.usersData.add(new Moderator("Vasya", "Zhirnov"));
    }

    public List<Person> getUsersData() {
        return usersData;
    }
}
