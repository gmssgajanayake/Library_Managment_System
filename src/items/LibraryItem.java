package items;

import java.lang.Comparable;
import java.util.UUID;

public interface LibraryItem extends Comparable<String> {

    default String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getTitle();

    public void setTitle(String title);

    public String getId();

}