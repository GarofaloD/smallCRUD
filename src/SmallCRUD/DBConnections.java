package SmallCRUD;

import java.sql.*;

public class DBConnections {

    public static ResultSet fetchAllFromDB() throws SQLException {

            databaseConnection();

            Statement statement = databaseConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("select * from Employee3");



            return resultSet;

    }

    public static ResultSet fetchOneFromDB(int id) throws SQLException {

        databaseConnection();

        PreparedStatement preparedStatement = databaseConnection().prepareStatement("select * from Employee3 where id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    public static void insertOnDB(int id, String name, int age, int salary, String designation) throws SQLException {

        databaseConnection();

        PreparedStatement preparedStatement = databaseConnection().prepareStatement("insert into Employee3 values (?,?,?,?,?)"); //? are placeholders for the values

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, age);
        preparedStatement.setInt(4, salary);
        preparedStatement.setString(5, designation);

        preparedStatement.execute();
    }


    public static void updatePositionOnDB(int empId, String newPosition) throws SQLException {

        databaseConnection();

        PreparedStatement preparedStatement = databaseConnection().prepareStatement("update Employee3 set designation = ? where id = ?"); //? are placeholders for the values

        preparedStatement.setString(1, newPosition);
        preparedStatement.setInt(2, empId);

        preparedStatement.execute();
    }

    public void updateSalaryByPercentageOnDB(){

    }

    public void updateSalaryCustomOnDB(){

    }




    public static Connection databaseConnection() {

        String classForName = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(classForName);
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend","root","IosDev2021!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println(e);
        }




        return null;
    }


}
