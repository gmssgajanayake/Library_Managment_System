package view;

import items.LibraryItem;
import items.impl.Book;
import items.impl.DVDs;
import items.impl.Magazine;
import services.InventoryManager;

import java.util.Scanner;

public class Main {
    //private static final Scanner input = new Scanner(System.in);
    private static final InventoryManager<LibraryItem> inventoryManager = new InventoryManager<>();

    public static void initializr() {
        clearConsole();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|\t\tLibrary Management System\t\t|");
        System.out.println("+-------------------------------------------------------+\n");
        System.out.println("[1] Add Items\t\t\t[2] Remove Items\n");
        System.out.println("[3] Search Items\t\t[5] Filter Items\n");
        System.out.println("[4] Available Items\t\t[6] Inventory Items\n");

        int option = 0;
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("\nEnter option here : ");
            option = input.nextInt();
        } catch (Exception e) {
            System.out.println("*** Enter only numbers 1 to 6 ***");
            System.out.println("\n+---------------------------------------------------+\n");
            initializr();
        }

        System.out.println("\n+---------------------------------------------------+\n");

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
            default:
                initializr();
        }
    }

    private static void loadSearchItemsByTitle() {

    }

    private static void loadAddItemsMenu() {
        clearConsole();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|\tLibrary Management System - Add Items\t\t|");
        System.out.println("+-------------------------------------------------------+\n");
        System.out.println("[1] Add Books\t\t\t[2] Add Magazines\n");
        System.out.println("[3] Add DVDs\t\t\t[4] Back\n");

        int option = 0;
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("\nEnter option here : ");
            option = input.nextInt();
        } catch (Exception e) {
            System.out.println("*** Enter only numbers 1 to 4 ***");
            System.out.println("\n+---------------------------------------------------+\n");
            loadAddItemsMenu();
        }

        System.out.println("\n+---------------------------------------------------+\n");

        switch (option) {
            case 1:
                addBooks();
            case 2:
                addMagazines();
            case 3:
                addDVDs();
            case 4:
                initializr();
            default:
                loadAddItemsMenu();
        }
    }

    private static void loadRemoveItemsMenu() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|\tLibrary Management System - Remove Items\t\t|");
        System.out.println("+-------------------------------------------------------+\n");

        System.out.print("Enter title : ");
        String title = input.nextLine();
        LibraryItem libraryItem=inventoryManager.removeItem(title);


        if(libraryItem!=null){
            System.out.println();
            System.out.println("The item was found - ");
            System.out.println("\t"+libraryItem);
            loading("removed");
        }else {
            System.out.println("\n **** Item is not available ****");
            delay(1500);
        }
        initializr();
    }

    private static void loadPrintCurrentInventoryDetails() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        inventoryManager.printCurrentInventory();
        System.out.print("Press any key to go back : " + input.nextLine());
        initializr();
    }

    private static void loadPrintInventoryDetails() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        inventoryManager.printInventory();
        System.out.print("Press any key to go back : " + input.nextLine());
        initializr();
    }

    private static void addDVDs() {
        try {
            Scanner input = new Scanner(System.in);
            clearConsole();

            System.out.println("+-------------------------------------------------------+");
            System.out.println("|\tLibrary Management System - Add a DVDs\t\t|");
            System.out.println("+-------------------------------------------------------+\n");

            System.out.print("Title : ");
            String title = input.nextLine();
            String director;
            int duration;

            System.out.println();
            DVDs item= (DVDs) inventoryManager.checkOutOfInventory(title);

            if (item != null) {
                System.out.println("Director : " + item.getDirector());
                System.out.println();
                System.out.println("Duration : " + item.getDuration());
                System.out.println();
                inventoryManager.removeItemFromOutOfInventory(item);
                inventoryManager.addItem(item);
                loading("added");
            } else {
                System.out.print("Director : ");
                director = input.nextLine();
                System.out.println();
                System.out.print("Duration : ");
                duration = input.nextInt();
                System.out.println();
                inventoryManager.addItem(new DVDs(title, director, duration));
                loading("added");
            }

            System.out.println("\n------------------------------------------\n");
            loadAddItemsMenu();
        } catch (Exception e) {
            System.out.println("Invalid input");
            addDVDs();
        }
    }

    private static void addMagazines() {
        try {
            Scanner input = new Scanner(System.in);
            clearConsole();

            System.out.println("+-------------------------------------------------------+");
            System.out.println("|\tLibrary Management System - Add a Magazine\t\t|");
            System.out.println("+-------------------------------------------------------+\n");

            System.out.print("Title : ");
            String title = input.nextLine();
            String publisher;
            int issueNumber;

            System.out.println();

            Magazine item = (Magazine) inventoryManager.checkOutOfInventory(title);

            if (item != null) {
                System.out.println("Publisher : " + item.getPublisher());
                System.out.println();
                System.out.println("Issue Number : " + item.getIssueNumber());
                System.out.println();
                inventoryManager.removeItemFromOutOfInventory(item);
                inventoryManager.addItem(item);
                loading("added");
            } else {
                System.out.print("Publisher : ");
                publisher = input.nextLine();
                System.out.println();
                System.out.print("Issue Number : ");
                issueNumber = input.nextInt();
                System.out.println();
                inventoryManager.addItem(new Magazine(title, publisher, issueNumber));
                loading("added");
            }

            System.out.println("\n------------------------------------------\n");
            loadAddItemsMenu();
        } catch (Exception e) {
            System.out.println("Invalid input");
            addMagazines();
        }
    }

    private static void addBooks() {
        try {
            Scanner input = new Scanner(System.in);
            clearConsole();

            System.out.println("+-------------------------------------------------------+");
            System.out.println("|\tLibrary Management System - Add a Book\t\t|");
            System.out.println("+-------------------------------------------------------+\n");

            System.out.print("Title : ");
            String title = input.nextLine();
            String author;
            int numberOfPages;

            System.out.println();

            Book item = (Book) inventoryManager.checkOutOfInventory(title);

            if (item != null) {
                System.out.println("Author : " + item.getAuthor());
                System.out.println();
                System.out.println("Number of Pages : " + item.getNumberOfPages());
                System.out.println();
                inventoryManager.removeItemFromOutOfInventory(item);
                inventoryManager.addItem(item);
                loading("added");
            } else {
                System.out.print("Author : ");
                author = input.nextLine();
                System.out.println();
                System.out.print("Number of Pages : ");
                numberOfPages = input.nextInt();
                System.out.println();
                inventoryManager.addItem(new Book(title, author, numberOfPages));
                loading("added");
            }

            System.out.println("\n------------------------------------------\n");
            loadAddItemsMenu();
        } catch (Exception e) {
            System.out.println("Invalid input");
            addBooks();
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void loading(String action){
        System.out.print("Loading ");
        delay(300);
        System.out.print(".");
        delay(300);
        System.out.print(".");
        delay(300);
        System.out.print(".");
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b*** Successfully "+action+" ***");
        delay(1500);
    }

    private static void delay(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
