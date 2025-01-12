package view;

import items.LibraryItem;
import items.impl.Book;
import items.impl.DVDs;
import items.impl.Magazine;
import services.InventoryManager;

import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static final InventoryManager<LibraryItem> inventoryManager = new InventoryManager<>();

    public static void initializr() {
        clearConsole();
        System.out.println("[1] Add an Item");
        System.out.println("[2] Remove an Item");
        System.out.println("[3] Print Details of Inventory Items");
        System.out.println("[4] Print Details of Current Items");
        System.out.println("[5] Search Items by Title");

        System.out.print("\nEnter here : ");
        int option = input.nextInt();
        System.out.println("\n------------------------------------------\n");

        switch (option) {
            case 1:
                loadAddItemsMenu();
            case 2:
                loadRemoveItemsMenu();
            case 3:
                loadPrintInventoryDetails();
            case 4:
                loadPrintCurrentInventoryDetails();
            case 5:
                loadSearchItemsByTitle();
        }
    }

    private static void loadSearchItemsByTitle() {

    }


    private static void loadAddItemsMenu() {
        clearConsole();
        System.out.println("[1] Add Books");
        System.out.println("[2] Add Magazines");
        System.out.println("[3] Add DvDs");
        System.out.println("[4] Back");

        System.out.print("\nEnter here : ");
        int option = input.nextInt();
        System.out.println("\n------------------------------------------\n");

        switch (option) {
            case 1:
                addBooks();
            case 2:
                addMagazines();
            case 3:
                addDVDs();
            case 4:
                initializr();
        }
    }

    private static void loadRemoveItemsMenu() {
        clearConsole();

        System.out.print("Enter title : ");
        input.nextLine();
        String title = input.nextLine();
        System.out.println(inventoryManager.removeItem(title));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        initializr();
    }

    private static void loadPrintCurrentInventoryDetails() {
        clearConsole();
        inventoryManager.printCurrentInventory();
        System.out.print("Press any key to go back : " + input.nextLine());
        input.nextLine();
        initializr();
    }

    private static void loadPrintInventoryDetails() {
        clearConsole();
        inventoryManager.printInventory();
        System.out.print("Press any key to go back : " + input.nextLine());
        input.nextLine();
        initializr();
    }

    private static void addDVDs() {
        clearConsole();
        System.out.print("Title : ");
        input.nextLine(); // If this id removed, the title value does not pass  ????

        String title = input.nextLine();
        String director;
        int duration;

        DVDs item = (DVDs) inventoryManager.checkOutOfInventory(title);

        if (item != null) {
            System.out.print("Director : " + item.getDirector());
            System.out.print("Duration : " + item.getDuration());
            inventoryManager.addItem(item);
        } else {
            System.out.print("Director : ");
            director = input.nextLine();
            System.out.print("Duration : ");
            duration = input.nextInt();
            inventoryManager.addItem(new DVDs(title, director, duration));
        }

        System.out.println("\n------------------------------------------\n");
        loadAddItemsMenu();
    }

    private static void addMagazines() {
        clearConsole();
        System.out.print("Title : ");
        input.nextLine(); // If this id removed, the title value does not pass  ????

        String title = input.nextLine();
        String publisher;
        int issueNumber;

        Magazine item = (Magazine) inventoryManager.checkOutOfInventory(title);

        if (item != null) {
            System.out.print("Publisher : " + item.getPublisher());
            System.out.print("Issue Number : " + item.getIssueNumber());
            inventoryManager.addItem(item);
        } else {
            System.out.print("Publisher : ");
            publisher = input.nextLine();
            System.out.print("Issue Number : ");
            issueNumber = input.nextInt();
            inventoryManager.addItem(new Magazine(title, publisher, issueNumber));
        }

        System.out.println("\n------------------------------------------\n");
        loadAddItemsMenu();
    }

    private static void addBooks() {
        clearConsole();
        System.out.print("Title : ");
        input.nextLine(); // If this id removed, the title value does not pass  ????

        String title = input.nextLine();
        String author;
        int numberOfPages;

        Book item = (Book) inventoryManager.checkOutOfInventory(title);

        if (item != null) {
            System.out.print("Author : " + item.getAuthor());
            System.out.print("Number of Pages : " + item.getNumberOfPages());
            inventoryManager.addItem(item);
        } else {
            System.out.print("Author : ");
            author = input.nextLine();
            System.out.print("Number of Pages : ");
            numberOfPages = input.nextInt();
            inventoryManager.addItem(new Book(title, author, numberOfPages));
        }

        System.out.println("\n------------------------------------------\n");
        loadAddItemsMenu();
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
