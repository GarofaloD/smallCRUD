package SmallCRUD;

import java.sql.SQLOutput;
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
                case 1 -> insertEmployeeMenu();
                case 2 -> processFetchEmployees();
                case 3 -> processUpdateSalaries();
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

    public static void insertEmployeeMenu(){

        System.out.println("=====Insert Employee Menu=====");

        System.out.println("New Employee Id");
        int empId = scanner.nextInt();

        System.out.println("New Employee Name");
        String empName = scanner.next();

        System.out.println("New Employee Id");
        int empAge = scanner.nextInt();

        System.out.println("New Employee Id");
        double empSalary = scanner.nextDouble();

        System.out.println("New Salary Designation");
        String empDesignation = scanner.next();


    }

    public static void processFetchEmployees(){

        int choiceFetch;
        boolean quitToMain = false;

        while (!quitToMain){
            System.out.println("======Show Employees=======");
            System.out.println("select your option:");
            System.out.println("1. Show all Employees");
            System.out.println("2. Search employee by employee ID");
            System.out.println("3. Exit to main menu");

            choiceFetch = scanner.nextInt();

            switch (choiceFetch){
                case 1 -> CRUDOperations.readAll();
                case 2 -> CRUDOperations.readOne();
                case 3 -> quitToMain = true;
                default -> System.out.println("Wrong selection. Make sure you select an option from the menu");
            }
        }





    }

    public static void processUpdateSalaries(){

    }

    public static void processDeleteEmployee(){

    }


}