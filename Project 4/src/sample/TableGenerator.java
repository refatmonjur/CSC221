package sample;

import java.sql.*;
public class TableGenerator {

    // creating the tables
    static void createTables(Connection con) throws Exception
    {
        PreparedStatement statement;

        //creates the students table
        statement = con.prepareStatement("create table if not exists students(studentID int not null primary key , first_name varchar(50) , " +
                "last_name varchar(50) , " + "email varchar(50) , " + "sex varchar(1) check (sex in ('M' , 'F', 'U')));");
        statement.executeUpdate();
        System.out.println("Student Table Created");

        //creates the courses table
        statement = con.prepareStatement("create table if not exists courses(course int not null primary key auto_increment , courseID varchar(50) , " +
                "courseTitle varchar(50) , " + "department varchar(50));");
        statement.executeUpdate();
        System.out.println("Course Table Created");


        //creates the classes table
        statement = con.prepareStatement("create table if not exists classes(classCode int not null auto_increment primary key ," +
                " courseID varchar(50) , studentID int unique references students(studentID) ," +
                " sectionNo char , year int , semester varchar(10) check (semester in ('FALL'))," +
                " grade varchar(1) check (grade in ('A' , 'B' , 'C' , 'D' , 'F' , 'W')))");
        statement.executeUpdate();
        System.out.println("Class Table Created");
    }

    public static void createNewStudent(Connection connection, int studentID, String first_name, String last_name, String email, String sex) {
        ResultSet rs = null;
        String sql = "INSERT INTO students(studentID,first_name,last_name,email,sex) " + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, studentID);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, email);
            pstmt.setString(5, sex);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    System.out.println("Successfully added student " + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void clearPreviousTables(Connection conn) {
        try {
            if (conn != null) {
                PreparedStatement stmt1 = conn.prepareStatement("DROP TABLE students");
                stmt1.execute();

                PreparedStatement stmt2 = conn.prepareStatement("DROP TABLE courses");
                stmt2.execute();

                PreparedStatement stmt3 = conn.prepareStatement("DROP TABLE classes");
                stmt3.execute();
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    // Allows to update students name and sex. Student id should stay the same//
    public static void updateStudent(Connection connection, int studentID, String first_name, String last_name, String email, String sex) {
        String sqlUpdate = "UPDATE students " + "SET first_name = ?, last_name = ? " + "WHERE studentID = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
            pstmt.setInt(1, studentID);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, email);
            pstmt.setString(5, sex);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    // Prints list of students
    public static void readStudentsList(Connection connection){
        String sql = "SELECT * FROM students";

        try {
            Statement stmt  = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("studentID") + "\t" + rs.getString("first_name") +
                        "\t" + rs.getString("last_name") + "\t " + "Email:"  + rs.getString("email") + "\t" + "Sex: "  + rs.getString("sex"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readClassesTable(Connection connection){
        String sql = "SELECT * FROM classes";

        try {
            Statement stmt  = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("courseID") + "\t" + rs.getString("studentID") +
                        "\t" +"sectionNo:" + rs.getString("sectionNo") + "\t "  + "Year:" + rs.getString("year") + "\t" + "Semester:" +
                        rs.getString("semester") + "\t" + "Grade:" +  rs.getString("grade"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readCoursesTable(Connection connection){
        String sql = "SELECT * FROM courses";

        try {
            Statement stmt  = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("courseID") + "\t" + rs.getString("courseTitle") + "\t" + rs.getString("department"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Enters data into the students table
    static void studentsTable(Connection con) throws Exception {
        PreparedStatement statement1;
        String insertion;

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23531671' , 'REFAT' , 'MONJUR' , 'rmonjur000@citymail.cuny.edu ', 'M')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23664959' , 'CINDY' , 'RODRIGUEZ' , 'crodriguez000@citymail.cuny.edu ', 'F')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23664906' , 'AMELIA' , 'ALAVERZ' , 'aalaverz000@citymail.cuny.edu ', 'U')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23666782' , 'ALTAIR' , 'SALVADOR' , 'asalvador000@citymail.cuny.edu ', 'M')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23664908' ,'KYLE' , 'CARTMAN' , 'kcartman000@citymail.cuny.edu ', 'U')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23564909' ,'MINDY' , 'RODRIGUEZ' , 'mrodriguez000@citymail.cuny.edu ', 'U')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23564910' ,'JOSH' , 'BLAIR' , 'jblair000@citymail.cuny.edu ', 'M')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23555990' ,'STEVE' , 'ROBS' , 'srobs000@citymail.cuny.edu ', 'M')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23564915' ,'JAMIE' , 'ROBERTS' , 'jamieroberts000@citymail.cuny.edu ', 'F')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23565682' ,'ALEXANDER' , 'RUSSELL' , 'arussell@citymail.cuny.edu ', 'M')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23578617' ,'KATHERINE' , 'REYES' , 'kreyes000@citymail.cuny.edu ', 'F')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23566385' ,'DANIA' , 'COLON' , 'dcolon000@citymail.cuny.edu ', 'F')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23632851' ,'JACOB' , 'SMITH' , 'jsmith000@citymail.cuny.edu ',  'M')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23644816' ,'ANGIE' , 'HERNANDEZ' , 'ahernandez000@citymail.cuny.edu ', 'F')";
        statement1 = con.prepareStatement(insertion);
        statement1.executeUpdate();

//        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23681542' ,'Maria' , 'Caba' , 'mcaba71@citymail.cuny.edu ', 'F')";
//        statement1 = con.prepareStatement(insertion);
//        statement1.executeUpdate();
//
//        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23685129' ,'John' , 'Ortiz' , 'jortiz000@citymail.cuny.edu ', 'F')";
//        statement1 = con.prepareStatement(insertion);
//        statement1.executeUpdate();
//
//        insertion = "insert into students(studentID, first_name , last_name , email , sex) values('23631245' ,'Mohammed' , 'HAQUE' , 'mhaque001@citymail.cuny.edu ',  'M')";
//        statement1 = con.prepareStatement(insertion);
//        statement1.executeUpdate();
    }

    //Enters data onto the courses table
    static void coursesTable(Connection con) throws Exception {
        PreparedStatement s;
        String insertion;

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' , 'Algorithms','Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID ,courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' , 'Algorithms','Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID ,courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' , 'Algorithms','Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

        insertion = "insert into courses(courseID ,courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
        s = con.prepareStatement(insertion);
        s.executeUpdate();

//        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
//        s = con.prepareStatement(insertion);
//        s.executeUpdate();
//
//        insertion = "insert into courses(courseID , courseTitle, department) values('CSC 22000' , 'Algorithms','Computer Science');";
//        s = con.prepareStatement(insertion);
//        s.executeUpdate();
//
//        insertion = "insert into courses(courseID ,courseTitle, department) values('CSC 22000' ,'Algorithms', 'Computer Science');";
//        s = con.prepareStatement(insertion);
//        s.executeUpdate();

    }

    //Enters data in the classes table
    static void classesTable(Connection con) throws Exception
    {
        String insertion;
        PreparedStatement statement;


        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23531671 , 'D' , 2020 , 'FALL' , 'C')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23364959 , 'D' , 2020 , 'FALL' , 'B')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23364906 , 'D' , 2020 , 'FALL' , 'C')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23366782 , 'D' , 2020 , 'FALL' , 'A')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23364908 , 'D' , 2020 , 'FALL' , 'F')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23364909 , 'D' , 2020 , 'FALL' , 'D')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23364910 , 'D' , 2020 , 'FALL' , 'C')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23355990 , 'D' , 2020 , 'FALL' , 'C')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23364915 , 'D' , 2020 , 'FALL' , 'W')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23365682 , 'D' , 2020 , 'FALL' , 'B')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23378617 , 'D' , 2020 , 'FALL' , 'A')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23566385 , 'D' , 2020 , 'FALL' , 'B')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23332851 , 'D' , 2020 , 'FALL' , 'B')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23524816 , 'D' , 2020 , 'FALL' , 'C')";
        statement = con.prepareStatement(insertion);
        statement.executeUpdate();

//        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23681542 , 'D' , 2020 , 'FALL' , 'D')";
//        statement = con.prepareStatement(insertion);
//        statement.executeUpdate();
//
//        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23685129 , 'D' , 2020 , 'FALL' , 'C')";
//        statement = con.prepareStatement(insertion);
//        statement.executeUpdate();
//
//        insertion = "insert into classes(courseID , studentID , sectionNo , year , semester , grade) values('CSC 22000' , 23631245 , 'D' , 2020 , 'FALL' , 'C')";
//        statement = con.prepareStatement(insertion);
//        statement.executeUpdate();

    }

}

