package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Store store = new Store();
    private static final Scanner sc = new Scanner(System.in);

    public static void drawMenu() throws IOException {
        int n;
        do {
            System.out.println("1. Add CD");
            System.out.println("2. Search CD by Title");
            System.out.println("3. Search CD by Collection");
            System.out.println("4. Search CD by Type");
            System.out.println("5. Delete CD by CD ID");
            System.out.println("6. Edit CD information by ID");
            System.out.println("7. Display all CD");
            System.out.println("8. Sort the CD list ascending by year of release");
            System.out.println("9. Exit Program");
            n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    store.addCD();
                    break;
                case 2:
                    System.out.print("Enter CD Title: ");
                    String title = sc.nextLine();
                    store.findTitle(title);
                    break;
                case 3:
                    System.out.print("Enter CD Collection: ");
                    String collection = sc.nextLine();
                    store.findCollection(collection);
                    break;
                case 4:
                    System.out.print("Enter CD Type: ");
                    String type = sc.nextLine();
                    store.findType(type);
                    break;
                case 5:
                    System.out.print("Delete CD by ID: ");
                    String id = sc.nextLine();
                    store.deleteByID(id);
                    break;
                case 6:
                    System.out.print("Enter CD ID to Edit: ");
                    String editID = sc.nextLine();
                    store.editCD(editID);
                    break;
                case 7:
                    store.displayAll();
                    break;
                case 8:
                    store.sortYearAscending();
                    System.out.println("Sorting operation finished, use the menu to display all CDSs");
                    break;
                case 9:
                    System.out.print("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (n != 9);
    }
    public static void main(String[] args) throws IOException {
        drawMenu();
    }
}