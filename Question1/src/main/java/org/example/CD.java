package org.example;

import java.util.Scanner;

public class CD {
    private static Scanner sc = new Scanner(System.in);
    private String id;
    private String collection;
    private String type;
    private String title;
    private int price;
    private int releaseYear;

    public CD(String id, String collection, String type, String title, int price, int releaseYear) {
        this.id = id;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.releaseYear = releaseYear;
    }

    public CD(){}

    public void addInfo(){
        System.out.print("Entering new CD.");
        System.out.print("Enter ID: ");
        id = sc.nextLine();
        System.out.print("Enter Collection: ");
        collection = sc.nextLine();
        System.out.print("Enter Type: ");
        type = sc.nextLine();
        System.out.print("Enter Title: ");
        title = sc.nextLine();
        System.out.print("Enter Price: ");
        price = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Release Year: ");
        releaseYear = sc.nextInt();
        sc.nextLine();
    }

    public void getInfo(){
        System.out.println("CD ID: " + this.id);
        System.out.println("CD Collection: " + this.collection);
        System.out.println("CD Type: " + this.type);
        System.out.println("CD Title: " + this.title);
        System.out.println("CD Price: " + this.price);
        System.out.println("CD Release Year: " + this.releaseYear);
        System.out.println();
    }

    public void editCD() {
        int choice;
        do {
            System.out.print("Which information do you want to edit?\n");
            System.out.print("1. Edit ID\n");
            System.out.print("2. Edit Collection\n");
            System.out.print("3. Edit Type\n");
            System.out.print("4. Edit Title\n");
            System.out.print("5. Edit Price\n");
            System.out.print("6. Edit Release Year\n");
            System.out.print("7. Exit\n");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline left-over
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    id = sc.nextLine();
                    break;
                case 2:
                    System.out.print("Enter Collection: ");
                    collection = sc.nextLine();
                    break;
                case 3:
                    System.out.print("Enter Type: ");
                    type = sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    break;
                case 5:
                    System.out.print("Enter Price: ");
                    price = sc.nextInt();
                    break;
                case 6:
                    System.out.print("Enter Release Year: ");
                    releaseYear = sc.nextInt();
                    break;
                case 7:
                    break;
                default:
                    System.out.print("Invalid choice. Please enter a number between 1 and 7.\n");
            }
        } while(choice != 7);
    }

    public String getTitle() {
        return title;
    }
    public String getCollection() {
        return collection;
    }
    public String getType(){
        return type;
    }
    public String getId(){
        return id;
    }
    public int getReleaseYear(){
        return releaseYear;
    }

}
