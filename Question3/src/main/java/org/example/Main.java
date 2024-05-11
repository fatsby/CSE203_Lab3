package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Company company = new Company();
    private static final Scanner sc = new Scanner(System.in);

    public static void drawMenu() throws IOException {
        int n;
        do {
            System.out.println("1. Add Full Time Employee");
            System.out.println("2. Add Part Time Employee");
            System.out.println("3. Show all Full Time Employees");
            System.out.println("4. Show all Part Time Employees");
            System.out.println("5. Show all Employees");
            System.out.println("6. Search Employee by ID");
            System.out.println("7. Delete Employee by ID");
            System.out.println("8. Edit Employee Information by ID");
            System.out.println("9. Search Employee by Payment");
            System.out.println("10. Sort all employee in ascending order by age, payment.");
            System.out.println("11. DEV: Generate Random Employees");
            System.out.println("12. EXIT");
            n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    company.addFullTimeEmployee();
                    break;
                case 2:
                    company.addPartTimeEmployee();
                    break;
                case 3:
                    System.out.println("Displaying all Full Time Employees");
                    company.showAllFullTimeEmployees();
                    break;
                case 4:
                    System.out.print("Displaying all Part Time Employees");
                    company.showAllPartTimeEmployees();
                    break;
                case 5:
                    System.out.print("Displaying all Employees");
                    company.showAllEmployee();
                    break;
                case 6:
                    System.out.print("Enter ID to search: ");
                    String id = sc.nextLine();
                    company.searchID(id);
                    break;
                case 7:
                    System.out.print("Enter ID to delete: ");
                    String deleteID = sc.nextLine();
                    company.deleteID(deleteID);
                    break;
                case 8:
                    System.out.print("Enter ID to edit: ");
                    String editID = sc.nextLine();
                    company.editID(editID);
                    break;
                case 9:
                    System.out.print("Enter amount from and to: ");
                    float from = sc.nextFloat();
                    float to = sc.nextFloat();
                    company.searchByPayment(from, to);
                    break;
                case 10:
                    company.sort();
                    break;
                case 11:
                    company.generateRandomEmployees();
                    break;
                case 12:
                    System.out.print("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (n != 12);
    }
    public static void main(String[] args) throws IOException {
        drawMenu();
    }
}