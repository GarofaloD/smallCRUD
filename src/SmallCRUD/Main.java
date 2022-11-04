package SmallCRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static CRUDOperations crudOperations = new CRUDOperations();


    public static void main(String[] args) {

        boolean quitProgram = false;
        int choice1;

        while(!quitProgram){

            Menu();

            choice1 = scanner.nextInt();

            switch (choice1){
                case 1 -> processInsertEmployee();
                case 2 -> menuFetchEmployees();
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
        System.out.println("3. Update Employee");
        System.out.println("4. Delete employee");
        System.out.println("5. Exit");
    }

    public static void processInsertEmployee(){

        System.out.println("=====Insert Employee Menu=====");

        System.out.println("New Employee Id");
        int empId = scanner.nextInt();

        ArrayList<Employee> employeesReturned = crudOperations.getOneFromDB(empId);

        if(!employeesReturned.isEmpty()){
            System.out.println("Employee is already in the database");
        } else {
            System.out.println("New Employee Name");
            String empName = scanner.next();

            System.out.println("New Employee Age");
            int empAge = scanner.nextInt();

            System.out.println("New Employee Salary");
            int empSalary = scanner.nextInt();

            System.out.println("New Employee Designation");
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
                crudOperations.insert(empId, empName, empAge, empSalary, empDesignation);
                System.out.println("Employee Created!");
            } else {
                System.out.println("Closing feature");
            }
        }



    }

    public static void menuFetchEmployees(){

        boolean quitFetchToMain = false;

        while (!quitFetchToMain){
            System.out.println("======Show Employees=======");
            System.out.println("select your option:");
            System.out.println("1. Show all Employees");
            System.out.println("2. Search employee by employee ID");
            System.out.println("4. Exit to main menu");

            int choiceFetch = scanner.nextInt();

            switch (choiceFetch){
                case 1 -> readAll();
                case 2 -> readOne();
                case 3 -> quitFetchToMain = true;
                default -> System.out.println("Wrong selection. Make sure you select an option from the menu");
            }
        }

    }

    public static void readOne(){

        System.out.println("Type the id of the employee");
        int idToSearch = scanner.nextInt();

        ArrayList<Employee> employeesReturned = crudOperations.getOneFromDB(idToSearch);

        printGet(employeesReturned);

    }

    public static void readAll(){

        ArrayList<Employee> employeesReturned = crudOperations.getAllFromDB();

        printGet(employeesReturned);


    }

    public static void processUpdateEmployee(){

        boolean quitUpdateToMain = false;

        while (!quitUpdateToMain){
            System.out.println("======Update Employees=======");
            System.out.println("select your option:");
            System.out.println("1. Update Designation");
            System.out.println("2. Update Salary (by percentage)");
            System.out.println("3. Update Salary (custom assignment)");
            System.out.println("3. Back to Main Menu");

            int choiceFetch = scanner.nextInt();

            switch (choiceFetch){
                case 1 -> updatePosition();
                case 2 -> updateSalaryByPercentage();
                case 3 -> updateSalaryCustom();
                case 4 -> quitUpdateToMain = true;
                default -> System.out.println("Wrong selection. Make sure you select an option from the menu");
            }
        }

    }


    public static void updatePosition(){
        System.out.println("=====Update Position=====");

        System.out.println("Employee Id");
        int empId = scanner.nextInt();

        ArrayList<Employee> employeesReturned = crudOperations.getOneFromDB(empId);

        if(employeesReturned.isEmpty()){
            System.out.println("Employee is not in the database");
        } else {
            System.out.println("Insert the new Designation (Clerk, Developer, tester, Manager )");
            String newPosition = scanner.next();

            crudOperations.updateEmployeePosition(empId, newPosition);
        }
    }

    public static void updateSalaryByPercentage(){
        System.out.println("=====Update Salary by Percentage=====");

        System.out.println("Employee Id");
        int empId = scanner.nextInt();

        ArrayList<Employee> employeesReturned = crudOperations.getOneFromDB(empId);

        if(employeesReturned.isEmpty()){
            System.out.println("Employee is not in the database");
        } else {
            System.out.println("Insert the percentage that you want to increase the salary (10%,15%,20%)");
            int salaryIncrease = scanner.nextInt();

            crudOperations.updateSalaryByPercentage(salaryIncrease);
        }
    }

    public static void updateSalaryCustom(){

    }


    public static void processDeleteEmployee(){

        System.out.println("=====Delete Employee Menu=====");

        System.out.println("Employee Id");
        int empId = scanner.nextInt();

        //verify that the employee exists first

        //If employee exists....



    }











    //Utility Methods
    private static void printGet(ArrayList<Employee> employeeArrayList) {
        if(employeeArrayList.isEmpty()){
            System.out.println("Data not found");
        } else {
            for (Employee employeeInList: employeeArrayList) {
                System.out.println("ID: " + employeeInList.getId()
                        + " :: Name: " + employeeInList.getName()
                        + " :: Designation: " + employeeInList.getDesignation());
            }
            System.out.println("Data Fetched");
        }
    }








}






