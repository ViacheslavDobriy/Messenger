/**
 * Описываю объект ID
 */
public class ID {
    private Person person;
    private int ID;

    public ID(Person person) {
        this.person = person;
        ID = MemberStorage.count++;
        System.out.printf("Your ID is %d\n", ID);
        MemberStorage.getIdStorage().add(this);
    }

    public Person getPerson() {
        return person;
    }

    public int getID() {
        return ID;
    }
}
