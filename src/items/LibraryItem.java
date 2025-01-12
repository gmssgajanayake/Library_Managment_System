package items;

import java.lang.Comparable;
import java.util.UUID;

public interface LibraryItem extends Comparable<LibraryItem> {

    default String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getId();

    public void setTitle(String title);

    public String getTitle();

}