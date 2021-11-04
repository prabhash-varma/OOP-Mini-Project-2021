import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    //Create
    public static void createStudent(Student stud){
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into student values(NULL,?,?)";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setString(1, stud.getName());
            stmt.setDouble(2, stud.getCgpa());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected+" student rows created.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Create
    public static void updateStudent(Student stud){
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "update student set name=?, cgpa=? where roll=?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setString(1, stud.getName());
            stmt.setDouble(2, stud.getCgpa());
            stmt.setInt(3, stud.getRoll());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected+" student rows updated.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    // Read - ALL
    public static List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from student";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student stud = new Student(rs.getInt("roll"),rs.getString("name"),rs.getDouble("cgpa"));
                students.add(stud);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    }
       // Read - ALL
       public static List<Student> getStudentByName(String name){
        List<Student> students = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from student where name = ?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student stud = new Student(rs.getInt("roll"),rs.getString("name"),rs.getDouble("cgpa"));
                students.add(stud);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    }

}

