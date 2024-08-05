// File: Test.java
import java.sql.*;

public class Test {

    public static void connect() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentManager", "root", "root");
            System.out.println("Connection to Store DB successful!");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from student");
          while(resultSet.next()){
              System.out.println(resultSet.getInt("StudentID"));
              System.out.println(resultSet.getString("FirstName"));

          }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}