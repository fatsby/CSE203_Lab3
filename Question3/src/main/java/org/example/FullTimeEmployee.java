package org.example;

import java.util.Scanner;

public class FullTimeEmployee extends Employee {
    private float salary;
    private static Scanner sc = new Scanner(System.in);
    public FullTimeEmployee() {}

    public void setInfo(){
        System.out.println("Entering Full Time Employee Info");
        System.out.print("Enter ID: ");
        setEmployeeID(sc.nextLine());
        System.out.print("Enter Name: ");
        setEmployeeName(sc.nextLine());
        System.out.print("Enter Year of Birth: ");
        setYearOfBirth(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Address: ");
        setAddress(sc.nextLine());
        System.out.print("Enter Phone: ");
        setPhone(sc.nextLine());
        System.out.print("Enter Salary: ");
        salary = sc.nextFloat();
        sc.nextLine();
    }

    @Override
    public String getInfo() {
        return "Employee ID: " + getEmployeeID() + "\n" +
                "Name: " + getEmployeeName() + "\n" +
                "Year of Birth: " + getYearOfBirth() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Phone: " + getPhone() + "\n" +
                "Salary: " + salary;
    }

    @Override
    public float getPayment() {
        return salary;
    }

    public String getID(){
        return getEmployeeID();
    }

    public void setInfoTest(String id, String name, int birthYear, String address, String phone, float salary){
        setEmployeeID(id);
        setEmployeeName(name);
        setYearOfBirth(birthYear);
        setAddress(address);
        setPhone(phone);
        this.salary = salary;
    }

    public String getName(){
        return getEmployeeName();
    }

    public void editEmployee(){
        int choice;
        do {
            System.out.print("Which information do you want to edit?\n");
            System.out.print("1. Edit ID\n");
            System.out.print("2. Edit Name\n");
            System.out.print("3. Edit Year of Birth\n");
            System.out.print("4. Edit Address\n");
            System.out.print("5. Edit Phone\n");
            System.out.print("6. Edit Salary\n");
            System.out.print("7. Exit\n");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline left-over
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    setEmployeeID(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    setEmployeeName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter Year of Birth: ");
                    setYearOfBirth(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Address: ");
                    setAddress(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Phone: ");
                    setPhone(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Salary: ");
                    salary = sc.nextInt();
                    break;
                case 7:
                    break;
                default:
                    System.out.print("Invalid choice. Please enter a number between 1 and 7.\n");
            }
        } while(choice != 7);
    }
}
