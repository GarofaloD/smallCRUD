package SmallCRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CRUDOperations {

    public ArrayList<Employee> getAllEmployees() {

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        try {
            ResultSet rs = DBConnections.fetchAllFromDB();

            processGetFromDB(employeeArrayList,rs);

        } catch (Exception e){
            System.out.println(e);

        }

        return employeeArrayList;
    }

    public ArrayList<Employee> getOneEmployee(int id){

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        try {
            ResultSet rs = DBConnections.fetchOneFromDB(id);

            processGetFromDB(employeeArrayList, rs);

        } catch (Exception e){
            System.out.println(e);

        }

        return employeeArrayList;
    }

    public void insertEmployee(int employeeId, String employeeName, int employeeAge, int employeeSalary, String employeeDesignation ){

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

    public void updateEmployeeSalaryByPercentage(int id, int percentageToIncrease){

        float salary = 0;
        float newSalary = 0;

        try {
            ResultSet rs = DBConnections.fetchOneFromDB(id);

            while (rs.next()){
                salary = rs.getInt(4);
            }

            System.out.println(salary);
            float percentage = percentageToIncrease / 100f;
            newSalary = salary + (salary * percentage);

            System.out.println(newSalary);
            DBConnections.updateSalaryByPercentageOnDB(id, (int)newSalary);

        } catch (Exception e){
            System.out.println(e);

        }
    }


    public void deleteEmployee(int id){

        try {

            DBConnections.deleteFromDB(id);

        } catch (Exception e){
            System.out.println(e);

        }

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
