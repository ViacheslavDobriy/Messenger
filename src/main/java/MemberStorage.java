import java.util.ArrayList;
import java.util.List;

/**
 * Здесь хранятся все ID членов мессенджера
 */
public class MemberStorage {
    private static final List<ID> idStorage = new ArrayList<>();
    static int count = 0;

    private MemberStorage() {}

    public static List<ID> getIdStorage(){
        return idStorage;
    }
}
