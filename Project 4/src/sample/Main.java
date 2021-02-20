package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.sql.*;

public class Main extends Application {
    static Connection conn = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        {
            VBox root = new VBox();


            PieChart p = new PieChart(conn);
            for (int i = 0; i < 6; i++) {
                Text t = new Text();
                root.getChildren().add(t);
                t.setFill(Color.rgb(p.rgb[i][0], p.rgb[i][1], p.rgb[i][2]));
                t.setFont(Font.font(20));
                t.setText( "Grade: " + p.gpa[i] + " - Students: " + p.count_gpa[i] + " - " + p.percentage[i] + "% Overall");
            }

            Text t = new Text();
            root.getChildren().add(t);
            t.setFill(Color.BLACK);
            t.setFont(Font.font(20));
            t.setText("Total Number of Students: " + p.number_of_students );


            Scene scene1 = new Scene(root, 700, 650);
            Canvas canvas = new Canvas(500, 550);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            root.getChildren().addAll(canvas);
            p.draw(gc);


            primaryStage.setTitle("Pie Chart");
            primaryStage.setScene(scene1);
            primaryStage.show();
        }
    }


    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //mysql connection with login
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java", "root", "Bronx");
            System.out.println("Connection Established");

            TableGenerator.clearPreviousTables(conn);
            TableGenerator.createTables(conn);
            TableGenerator.studentsTable(conn);
            TableGenerator.coursesTable(conn);
            TableGenerator.classesTable(conn);
            System.out.println();
            System.out.println("Students Table:");
            TableGenerator.readStudentsList(conn);
            System.out.println();
            System.out.println("Classes Table:");
            TableGenerator.readClassesTable(conn);
            System.out.println();
            System.out.println("Courses Table:");
            TableGenerator.readCoursesTable(conn);
            System.out.println("Database Successfully built!");

//            TableGenerator.deleteStudentsRow(conn, 23531671);
//            TableGenerator.deleteStudentsRow(conn, 23534876);
//            TableGenerator.deleteStudentsRow(conn, 23634872);
            //The following commands will only work if I stop adding a new entry//

//            TableGenerator.createNewStudent(conn,23534876, "ALEJANDRA", "GARCIA", "agarcia61@citymail.cuny.edu", "F");
//            TableGenerator.updateStudent(conn,23534876, "ALEJANDRA", "GARCIA", "agarcia61@citymail.cuny.edu", "F");
//
//            TableGenerator.createNewStudent(conn,23634872, "MARK", "HENRY", "mhenry@citymail.cuny.edu", "M");
//            TableGenerator.updateStudent(conn,23634872, "MARK", "HENRY", "mhenry@citymail.cuny.edu", "M");

        }
        catch (Exception e) {
            System.out.println("Exception caught " + e);
        }
        launch(args);
    }
}


//            PreparedStatement s = conn.prepareStatement("drop table students, courses , classes");
//            s.executeUpdate();
//            System.out.println("Classes dropped");
//
//            system.out.println("Creating tables...");
//            TableGenerator.createTables(con);
//
//            System.out.println("Building courses table...");
//            TableGenerator.coursesTable(con);
//
//            System.out.println("Building students table...");
//            TableGenerator.studentsInfo(con);
//
//            System.out.println("Building classes table...");
//            TableGenerator.classesTable(con);
//
//            System.out.println("Database successfully built!");
//
////
////This what is asked in the exercise to display number of students with the given condition
////            System.out.println("Number of students enrolled in CSC211 in the Fall 2019 are");
////            PreparedStatement p = con.prepareStatement("select count(studentID) from classes natural join courses where year = 2019 and semester = 'Fall' and courseTitle = 'CS211'");
////            ResultSet r1 = p.executeQuery();
////            while(r1.next())
////            {
////                System.out.println(r1.getInt("count(studentID)"));
////            }
////
////This contains list of students who has cleared the desired conditions.
////            System.out.println("List of students :-");
////            PreparedStatement p1 = con.prepareStatement("select studentID , first_name , last_name, GPA from classes natural join courses natural join students where year = 2019 and semester = 'Fall' and courseTitle = 'CS211';");
////            ResultSet r2 = p1.executeQuery();
////            System.out.println("StudentID\t" + "First Name\t" + "Last Name\t\t" + "   GPA");
////            while(r2.next())
////            {
////                System.out.print(r2.getInt("studentID") + "\t\t");
////                System.out.print(r2.getString("first_name") + "\t\t");
////                System.out.print(r2.getString("last_name") + "\t\t");
////                System.out.print(r2.getString("GPA"));
////
////                System.out.println();
////            }
////
////            launch(args);
////        }
