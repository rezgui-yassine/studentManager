// File: Test.java
import java.sql.*;

public class Test {

    public static void connect() {
       try{
           Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentManager","root","root");
              System.out.println("Connection successful");
              //create a statement object for executing SQL queries
              Statement statement = connection.createStatement();
              //execute a query to get a result set from the database table student
                ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

                int compteur = 0;
           while (resultSet.next()) {
                compteur++;
               System.out.println(String.format("%-15s %-15s %-15s %-15s",
                       resultSet.getInt("StudentID"),
                       resultSet.getString("FirstName"),
                       resultSet.getString("LastName"),
                       resultSet.getString("DateOfBirth")));

           }
           System.out.println("Number of students: "+compteur);
       }catch (SQLException e){
           System.err.println("Connection failed"+e.getMessage());

       }
    }
}