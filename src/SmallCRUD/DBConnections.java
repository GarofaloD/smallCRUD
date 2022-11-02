package SmallCRUD;

import java.sql.*;

public class DBConnections {

    public static ResultSet fetchAllFromDB() throws SQLException {

            databaseConnection();

            Statement statement = databaseConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("select * from Employee3");

            return resultSet;

    }








    public void updateOnDB(){

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
