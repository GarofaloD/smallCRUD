package SmallCRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CRUDOperations {

    public ArrayList<Employee> getAllFromDB() {

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        try {
            ResultSet rs = DBConnections.fetchAllFromDB();

            processGetFromDB(employeeArrayList,rs);

        } catch (Exception e){
            System.out.println(e);

        }

        return employeeArrayList;
    }

    public ArrayList<Employee> getOneFromDB(int id){

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        try {
            ResultSet rs = DBConnections.fetchOneFromDB(id);

            processGetFromDB(employeeArrayList, rs);

        } catch (Exception e){
            System.out.println(e);

        }

        return employeeArrayList;
    }



    public void insert(int employeeId, String employeeName, int employeeAge, int employeeSalary, String employeeDesignation ){

        try {

            DBConnections.insertOnDB(employeeId, employeeName, employeeAge, employeeSalary, employeeDesignation);

        } catch (Exception e){
            System.out.println(e);

        }


    }

    public void updateEmployeePosition(int id, String newPosition){

        try {

            DBConnections.updatePositionOnDB(id, newPosition);

        } catch (Exception e){
            System.out.println(e);

        }


    }

    public void updateSalaryByPercentage(int percentageToIncrease){

//        ArrayList<Employee> employeeArrayList = new ArrayList<>();
//
//        try {
//            ResultSet rs = DBConnections.fetchOneFromDB(id);
//
//            processGetFromDB(employeeArrayList, rs);
//
//        } catch (Exception e){
//            System.out.println(e);
//
//        }
//
//        return employeeArrayList;

    }

    public void updateSalaryCustom(){

    }

    public static void delete(){

    }




    //Utility Methods
    private static void processGetFromDB(ArrayList<Employee> employeeArrayList,ResultSet rs) throws SQLException {

        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            int salary = rs.getInt(4);
            String designation = rs.getString(5);

            Employee emp = new Employee(id, name, age, salary, designation);

            employeeArrayList.add(emp);
        }

    }





}
