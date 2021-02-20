package sample;

import java.sql.*;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Demonstrates interaction between a Java program and a database. *
 * @author Java Foundations
 * @version 4.0
 */
public class DatabaseModification {
    /**
     * Carries out various CRUD operations after establishing the * database connection.
     */
    public static void main(String args[]) {
        Connection conn = null;
        try {
// Loads the class object for the mysql driver into the DriverManager.
            Class.forName("com.mysql.cj.jdbc.Driver");
            //  Attempt to establish a connection to the specified database via the
            //  DriverManager
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" , "root", "Bronx");
            // Check the connection
            if (conn != null) {
                System.out.println("We have connected to our database!");
                //  Create the table and show the table structure

                ////This what is asked in the exercise to display number of students with the given condition
//             System.out.println("Number of students enrolled in this Class for this Semester:");
               PreparedStatement table1 = conn.prepareStatement("CREATE TABLE Students " +
                        " (EMPLID INT UNSIGNED NOT NULL , " + " PRIMARY KEY (EMPLID), " + "firstName varchar(255), " + " lastName varchar(255), " +
                       " email varchar(255), " + " sex char(1)," + " check(sex = 'M' or sex = 'F' or sex ='U'))");
               table1.execute();
//                System.out.println("\tTable creation result: " + result);
//                DatabaseModification.showColumns(conn);
//// Insert the data into the database and show the values in the table

                PreparedStatement table2 = conn.prepareStatement("CREATE TABLE Courses " +
                        " (EMPLID INT UNSIGNED NOT NULL , " + " PRIMARY KEY (EMPLID), " + "firstName varchar(255), " + " lastName varchar(255), " +
                        " email varchar(255), " + " sex char(1)," + " check(sex = 'M' or sex = 'F' or sex ='U'))");
                table2.execute();
//                Statement stmt2 = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
//                int rowCount = stmt2.executeUpdate("INSERT Student " + "(lastName, age, gpa) VALUES (\"Campbell\", 19, 3.79)");
//                DatabaseModification.showValues(conn);
                //  Close the database
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
//
//    /**
//     * Obtains and displays a ResultSet from the Student table.
//     */
//
//    public static void showValues(Connection conn) {
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rset = stmt.executeQuery("SELECT * FROM Student");
//            DatabaseModification.showResults("Student", rset);
//        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//
//    /**
//     * Displays the structure of the Student table.
//     */
//    public static void showColumns(Connection conn) {
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rset = stmt.executeQuery("SHOW COLUMNS FROM Student");
//            DatabaseModification.showResults("Student", rset);
//        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//
//    /**
//     * Displays the contents of the specified ResultSet.
//     */
//    public static void showResults(String tableName, ResultSet rSet) {
//        try {
//            ResultSetMetaData rsmd = rSet.getMetaData();
//            int numColumns = rsmd.getColumnCount();
//            String resultString = null;
//            if (numColumns > 0) {
//                resultString = "\nTable: " + tableName + "\n" +
//                        "=======================================================\n";
//                for (int colNum = 1; colNum <= numColumns; colNum++) resultString += rsmd.getColumnLabel(colNum) + " ";
//            }
//            System.out.println(resultString);
//            System.out.println(
//                    "=======================================================");
//            while (rSet.next()) {
//                resultString = "";
//                for (int colNum = 1; colNum <= numColumns; colNum++) {
//                    String column = rSet.getString(colNum);
//                    if (column != null)
//                        resultString += column + " ";
//                }
//                System.out.println(resultString + '\n' +
//                        "------------------------------------------------------------");
//            }
//        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
}