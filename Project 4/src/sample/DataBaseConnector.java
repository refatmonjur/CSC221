//package sample;
//
//import java.sql.*;
//
//import javafx.application.Application;
////import javafx.scene.*;
////import javafx.scene.canvas.Canvas;
////import javafx.scene.canvas.GraphicsContext;
////import javafx.scene.layout.VBox;
////import javafx.scene.paint.Color;
////import javafx.scene.text.Font;
////import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//class DatabaseConnector extends Application{
//    static Connection conn = null;
//
//    public static void main(String[] args) {
//        // TODO code application logic here\
//
//
//            try
//            {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                //user and password is also entered for logging in to the database
//                //This login condition varies from database to database
//                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java" , "root", "Bronx");
//
//                PreparedStatement s = conn.prepareStatement("drop table students, courses , classes");
//                s.executeUpdate();
//
//                System.out.println("Creating tables...");
//                TableGenerator.createTables(conn);
//
//                System.out.println("Building courses table...");
//                TableGenerator.coursesTable(conn);
//
//                System.out.println("Building students table...");
//                TableGenerator.studentsTable(conn);
//
//                System.out.println("Building classes table...");
//                TableGenerator.classesTable(conn);
//
//                System.out.println("Database successfully built!");
//
//
//                //This what is asked in the exercise to display number of students with the given condition
//                System.out.println("Number of students enrolled in Fall 2020: ");
//                PreparedStatement p = conn.prepareStatement("select count(studentID) from classes natural join courses where year = 2020 and semester = 'Fall' and courseTitle = 'Algorithms'");
//                ResultSet r1 = p.executeQuery();
//                while(r1.next())
//                {
//                    System.out.println(r1.getInt("count(studentID)"));
//                }
//
//                //This contains list of students who has cleared the desired conditions.
//                System.out.println("List of students :-");
//                PreparedStatement p1 = conn.prepareStatement("select studentID , first_name , last_name, grade from classes natural join courses natural join students where year = 2020 and semester = 'Fall' and courseTitle = 'Algorithms';");
//                ResultSet r2 = p1.executeQuery();
//                System.out.println("StudentID\t" + "First Name\t" + "Last Name\t\t" + "   grade");
//                while(r2.next())
//                {
//                    System.out.print(r2.getInt("studentID") + "\t\t");
//                    System.out.print(r2.getString("first_name") + "\t\t");
//                    System.out.print(r2.getString("last_name") + "\t\t");
//                    System.out.print(r2.getString("grade"));
//
//                    System.out.println();
//                }
//
//                launch(args);
//            }
//            catch(Exception e)
//            {
//                System.out.println("Exception caught " + e);
//            }
//    }
//
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {}
//        {
////            VBox root = new VBox();
////            Scene scene1 = new Scene(root , 1000 , 1000);
////
////            PieChart p = new PieChart(conn);
////            for(int i=0; i<6; i++)
////            {
////                Text t = new Text();
////                root.getChildren().add(t);
////                t.setFill(Color.rgb(p.rgb[i][0] , p.rgb[i][1] , p.rgb[i][2]));
////                t.setFont(Font.font(25));
////                t.setText(p.gpa[i] + " - " + p.count_gpa[i] + " - " + p.percentage[i] + "% Overall");
////            }
////
////            Text t = new Text();
////            root.getChildren().add(t);
////            t.setFill(Color.BLACK);
////            t.setFont(Font.font(20));
////            t.setText("Total number of students - " + p.number_of_students);
////
////            Canvas canvas = new Canvas(500 , 500);
////            GraphicsContext gc = canvas.getGraphicsContext2D();
////            root.getChildren().add(canvas);
////            p.draw(gc);
//
//
//    //        primaryStage.setTitle("Pie Chart");
//     //       primaryStage.setScene(scene1);
//       //     primaryStage.show();
//        }
//
//}
//
