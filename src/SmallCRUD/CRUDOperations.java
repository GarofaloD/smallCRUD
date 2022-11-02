package SmallCRUD;

import java.sql.ResultSet;
import java.util.ArrayList;


public class CRUDOperations {

    static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public static void readAll() {

        try {
            ResultSet rs = DBConnections.fetchAllFromDB();

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int salary = rs.getInt(4);
                String designation = rs.getString(5);

                Employee emp = new Employee(id, name, age, salary, designation);

                employeeArrayList.add(emp);
            }

            for (Employee employeeInList: employeeArrayList) {
                System.out.println("ID: " + employeeInList.getId() + " :: Name: " + employeeInList.getName() + " :: Designation: " + employeeInList.getDesignation());
            }

            System.out.println("Data Fetched");

        } catch (Exception e){
            System.out.println(e);

        }





    }
//
//    public static void readOne(String id){
//
//        for(int i = 0; i < employeeArrayList.size(); i++){
//            if(employeeArrayList.get(i).getId().){
//                return filesinWorkingFolder.get(i);
//            }
//        }
//
//
//    }

    public static void insert(){

    }

    public static void updatePosition(){

    }

    public static void updateSalaryByPercentage(){

    }

    public static void updateSalaryCustom(){

    }

    public static void delete(){

    }


    public static void searchEmployee(){




    }

    public static void employeeOnFile(){

    }



}
