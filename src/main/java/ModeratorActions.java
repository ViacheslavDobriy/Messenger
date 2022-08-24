/**
 * Описываем интерфейс, как может действовать модератор
 */
public interface ModeratorActions extends UserActions{
    public void removeMessage();
    public void banUser(Person user);
}
