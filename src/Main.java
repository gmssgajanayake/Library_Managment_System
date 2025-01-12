import items.LibraryItem;
import items.impl.Book;
import items.impl.Magazine;
import items.impl.DVDs;
import manage.InventoryManager;

import java.util.LinkedList;

class Main {
    public static void main(String[] args) {

        InventoryManager<LibraryItem> inventory=new InventoryManager<>();

        Book b1=new Book("B1", "A1", 1);
        Magazine m1= new Magazine("M1", "R1", 1);
        DVDs d1=new DVDs("D1", "D1", 1);

        LinkedList<LibraryItem> list=new LinkedList<>();
        list.add(new Book("B2", "A2", 2));
        list.add(new Book("B3", "A2", 3));
        list.add(new Magazine("M1", "R1", 1));
        list.add(new DVDs("D2", "D1", 3));

        inventory.addItems(list);
        inventory.addItem(b1);
        inventory.addItem(m1);
        inventory.addItem(d1);

        inventory.printInventory();
        inventory.printCurrentInventory();

        inventory.removeItems(b1);

        inventory.printInventory();
        inventory.printCurrentInventory();

        


    }
}