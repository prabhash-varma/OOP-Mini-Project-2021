import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //Creation of students from CSV
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\subbu\\Dropbox\\code\\java\\mmproject\\mmproject\\src\\students.csv"));
            String studLine;
            while ((studLine = reader.readLine()) != null) {
                StudentDAO.createStudent(new Student(studLine));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student mary = new Student("mary", 6.6d);
        StudentDAO.createStudent(mary);
        mary = StudentDAO.getStudentByName("mary").get(0);
        //Listing all students
        List<Student> allStudents = StudentDAO.getAllStudents();
        allStudents.forEach(System.out::println);
        System.out.println();
        mary.setCgpa(7.8d);
        StudentDAO.updateStudent(mary);
        allStudents = StudentDAO.getAllStudents();
        allStudents.forEach(System.out::println);

    }
}
