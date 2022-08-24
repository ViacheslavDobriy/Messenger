/**
 * Описываем интерфейс, что может делать администратор
 */
public interface AdminActions extends ModeratorActions{
    public void removeUserFromChat(Person person);
    public void addUserInChat(Person person, Chat chat);
    public void giveRole(Person person);
}
