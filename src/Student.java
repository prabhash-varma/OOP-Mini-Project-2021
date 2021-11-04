public class Student {
    private int roll = -1;
    private String name;
    private double cgpa;
    public Student(int roll, String name, double cgpa) {
        this.roll = roll;
        this.name = name;
        this.cgpa = cgpa;
    }
    public Student(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }
    public Student(String studLine) {
        String values[] = studLine.split(",");
        this.name = values[0];
        this.cgpa = Double.valueOf(values[1]);
    }
    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    @Override
    public String toString() {
        return "Student [cgpa=" + cgpa + ", name=" + name + ", roll=" + roll + "]";
    }
    
}
