package SmallCRUD;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean quitProgram = false;
        int choice1;

        while(!quitProgram){

            Menu();

            choice1 = scanner.nextInt();

            switch (choice1){
                case 1 -> processInsertEmployee();
                case 2 -> processFetchEmployees();
                case 3 -> processUpdateEmployee();
                case 4 -> processDeleteEmployee();
                case 5 -> quitProgram = true;
                default -> System.out.println("Wrong selection. Make sure you select an option from the menu");
            }
        }
    }


    public static void Menu(){
        System.out.println("======CRUD PROGRAM=========");
        System.out.println("select your option:");
        System.out.println("1. Insert Employee");
        System.out.println("2. Display Employees");
        System.out.println("3. Raise salaries by 10% for everyone");
        System.out.println("4. Delete employee");
        System.out.println("5. Exit");
    }

    public static void processInsertEmployee(){

        System.out.println("=====Insert Employee Menu=====");

        System.out.println("New Employee Id");
        int empId = scanner.nextInt();

        //if the user is in the database, exit menu
        //Otherwise, keep asking for data

        System.out.println("New Employee Name");
        String empName = scanner.next();

        System.out.println("New Employee Id");
        int empAge = scanner.nextInt();

        System.out.println("New Employee Id");
        double empSalary = scanner.nextDouble();

        System.out.println("New Salary Designation");
        String empDesignation = scanner.next();

        System.out.println("Employee information:");
        System.out.println("Employee Id: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Age: " + empAge);
        System.out.println("Employee Salary: " + empSalary);
        System.out.println("Employee Designation: " + empDesignation);
        System.out.println("Are you sure you want to add the employee? (Y/N)");
        String employeeInsertChoice = scanner.next();

        if(employeeInsertChoice.equalsIgnoreCase("y")){
            CRUDOperations.insert();
            System.out.println("Employee Created");
        } else {
            System.out.println("Closing feature");
        }
    }

    public static void processFetchEmployees(){

        boolean quitFetchToMain = false;

        while (!quitFetchToMain){
            System.out.println("======Show Employees=======");
            System.out.println("select your option:");
            System.out.println("1. Show all Employees");
            System.out.println("2. Search employee by employee ID");
            System.out.println("3. Exit to main menu");

            int choiceFetch = scanner.nextInt();

            switch (choiceFetch){
                case 1 -> CRUDOperations.readAll();
                case 2 -> readOne();
                case 3 -> quitFetchToMain = true;
                default -> System.out.println("Wrong selection. Make sure you select an option from the menu");
            }
        }

    }

    public static void readOne(){

        System.out.println("Type the id of the employee");
        int idToSearch = scanner.nextInt();



    }



    public static void processUpdateEmployee(){

        boolean quitUpdateToMain = false;

        while (!quitUpdateToMain){
            System.out.println("======Update Employees=======");
            System.out.println("select your option:");
            System.out.println("1. Update Designation");
            System.out.println("2. Update Salary (by percentage)");
            System.out.println("3. Update Salary (custom assignment)");

            int choiceFetch = scanner.nextInt();

            switch (choiceFetch){
                case 1 -> CRUDOperations.updatePosition();
                case 2 -> CRUDOperations.updateSalaryByPercentage();
                case 3 -> CRUDOperations.updateSalaryCustom();
                case 4 -> quitUpdateToMain = true;
                default -> System.out.println("Wrong selection. Make sure you select an option from the menu");
            }
        }

    }

    public static void processDeleteEmployee(){

        System.out.println("=====Delete Employee Menu=====");

        System.out.println("Employee Id");
        int empId = scanner.nextInt();

        //verify that the employee exists first

        //If employee exists....



    }


}