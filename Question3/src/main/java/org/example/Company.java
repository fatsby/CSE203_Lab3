package org.example;

import java.util.*;

public class Company {
    ArrayList<FullTimeEmployee> fullTimeEmployees = new ArrayList<>();
    ArrayList<PartTimeEmployee> partTimeEmployees = new ArrayList<>();
    ArrayList<Employee> allEmployees = new ArrayList<>();
    Random  random = new Random();
    private static Scanner sc = new Scanner(System.in);
    public Company() {
    }
    public Company(ArrayList<FullTimeEmployee> fullTimeEmployees) {
        this.fullTimeEmployees = fullTimeEmployees;
    }

    public void generateRandomEmployees() {
        for (int i = 0; i < 3; i++) {
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
            fullTimeEmployee.setInfoTest(
                    "FT" + i,
                    "Full Time Employee " + i,
                    1980 + random.nextInt(40),
                    "Address " + i,
                    "Phone " + i,
                    2000 + random.nextInt(8000)
            );
            fullTimeEmployees.add(fullTimeEmployee);
            allEmployees.add(fullTimeEmployee);

            PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
            partTimeEmployee.setInfoTest(
                    "PT" + i,
                    "Part Time Employee " + i,
                    1980 + random.nextInt(40),
                    "Address " + i,
                    "Phone " + i,
                    random.nextInt(40),
                    50 + random.nextInt(50)
            );
            partTimeEmployees.add(partTimeEmployee);
            allEmployees.add(partTimeEmployee);
        }
    }

    public void addFullTimeEmployee() {
        System.out.println("How many employees do you wish to add?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            FullTimeEmployee employee = new FullTimeEmployee();
            employee.setInfo();
            fullTimeEmployees.add(employee);
            allEmployees.add(employee);
        }
    }
    public void showAllFullTimeEmployees() {
        for(FullTimeEmployee employee : fullTimeEmployees) {
            System.out.println(employee.getInfo());
            System.out.println();
        }
    }
    public void addPartTimeEmployee() {
        System.out.println("How many employees do you wish to add?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            PartTimeEmployee employee = new PartTimeEmployee();
            employee.setInfo();
            partTimeEmployees.add(employee);
            allEmployees.add(employee);
        }
    }
    public void showAllPartTimeEmployees() {
        for(PartTimeEmployee employee : partTimeEmployees) {
            System.out.println(employee.getInfo());
            System.out.println();
        }
    }
    public void showAllEmployee(){
        for(Employee employee : allEmployees) {
            System.out.println(employee.getInfo());
            System.out.println();
        }
    }
    public void searchID(String ID){
        boolean found = false;
        for(FullTimeEmployee employee : fullTimeEmployees) {
            if (employee.getID().equals(ID)){
                System.out.println();
                System.out.println(employee.getInfo());
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found){
            for(PartTimeEmployee employee : partTimeEmployees) {
                if (employee.getID().equals(ID)){
                    System.out.println();
                    System.out.println(employee.getInfo());
                    System.out.println();
                    found = true;
                    break;
                }
            }
        }
        if (!found){
            System.out.println("ID not found");
        }
    }

    public void deleteID(String ID){
        boolean found = false;
        for(FullTimeEmployee employee : fullTimeEmployees) {
            if (employee.getID().equals(ID)){
                System.out.println("Removed employee: " + employee.getEmployeeName());
                fullTimeEmployees.remove(employee);
                found = true;
                break;
            }
        }
        if (!found){
            for(PartTimeEmployee employee : partTimeEmployees) {
                if (employee.getID().equals(ID)){
                    System.out.println("Removed employee: " + employee.getEmployeeName());
                    partTimeEmployees.remove(employee);
                    found = true;
                    break;
                }
            }
        }
        if (!found){
            System.out.println("ID not found");
        }
    }
    public void editID(String ID){
        boolean found = false;
        for(FullTimeEmployee employee : fullTimeEmployees) {
            if (employee.getID().equals(ID)){
                employee.editEmployee();
                found = true;
                break;
            }
        }
        if (!found){
            for(PartTimeEmployee employee : partTimeEmployees) {
                if (employee.getID().equals(ID)){
                    employee.editEmployee();
                    found = true;
                    break;
                }
            }
        }
        if (!found){
            System.out.println("ID not found");
        }
    }
    public void searchByPayment(float from, float to){
        for(FullTimeEmployee employee : fullTimeEmployees) {
            if (employee.getPayment() >= from && employee.getPayment() <= to){
                System.out.println();
                System.out.println(employee.getInfo());
                System.out.println();
            }
        }
        for(PartTimeEmployee employee : partTimeEmployees) {
            if (employee.getPayment() >= from && employee.getPayment() <= to){
                System.out.println();
                System.out.println(employee.getInfo());
                System.out.println();
            }
        }
    }

    public void sort(){
        Comparator<Employee> ageThenPaymentComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // Compare by age first
                int ageCompare = Integer.compare(e1.getYearOfBirth(), e2.getYearOfBirth());
                if (ageCompare != 0) {
                    return ageCompare;
                }
                // If age is equal, compare by payment
                return Float.compare(e1.getPayment(), e2.getPayment());
            }
        };
        allEmployees.sort(ageThenPaymentComparator);
        System.out.println("Sort Operation finished, use Menu to show all Employees");
    }

}
