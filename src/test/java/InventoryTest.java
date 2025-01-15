import items.LibraryItem;
import items.impl.Book;
import items.impl.DVDs;
import items.impl.Magazine;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import services.InventoryManager;

public class InventoryTest{
    @Test
    public void addItems(){
        InventoryManager<LibraryItem> inventoryManager=new InventoryManager<>();
        inventoryManager.addItem(new Book("d","defc",32));
        inventoryManager.addItem(new Magazine("d","defc",32));
        inventoryManager.addItem(new DVDs("d","defc",32));
        inventoryManager.addItem(new Book("d","defc",32));
        inventoryManager.addItem(new Magazine("d","defc",32));
        inventoryManager.addItem(new Magazine("d","defc",32));
    }

    @Test
    public void removeItems(){
        InventoryManager<LibraryItem> inventoryManager=new InventoryManager<>();
        inventoryManager.removeItem(new Book("d","defc",32));
        inventoryManager.removeItem("Java");
    }
}