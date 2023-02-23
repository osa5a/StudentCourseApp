import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author osama
 */
public class Student {
    private String name;
    private int id;
    private double GPA;
    Course c;
    ArrayList<Course> courseList = new ArrayList<>();
    
    public Student(){
        this("", 0);
    }
    
    public Student(String n, int i){
        this(n, i, 0);
    }
    
    public Student(String n, int i, double g){
        name = n;
        GPA = g;
        id= i;
    }
    
    public Student(String name, int id, Student o){
        this.name = name;
        this.id = id;
        
        for (int i = 0; i < o.courseList.size(); i++) {
            addCourse(o.courseList.get(i));
        }
    }
    
    public void setName(String x) {
        name = x;
    }
    
    public String getName() {
        return name;
    }
    
    public void setID(int x){
        id = x;
    }
    
    public int getID(){
        return id;
    }
    
    public void setGPA(double x) {
        GPA = x;
    }
    
    public String getGPA() {
        String str = String.format("%.2f", GPA);
        return str;
    }
    
    
    public void addCourse(String courseName, String grade, String semesterName, int credit) {
        c = new Course(courseName, grade, semesterName, credit); // making temp object for entering the courseList
        courseList.add(c); // courseList only accept Course objects.
        
        updateAndGetGPA(); // updating the GPA
    }
    
    public void addCourse(Course o) {
        c = new Course(o.getCourseName(), o.getGrade(), o.getSemesterName(), o.getCredit());
        courseList.add(c);
        
        updateAndGetGPA();
    }
    
    
    public void removeCourse(String courseName) {
        
        Iterator<Course> iterate = courseList.iterator();
        // iterator is used to loop through the entire collection, which is in our case is couresList (ArrayList)
        
        while(iterate.hasNext()){
            Course x = iterate.next();
            String y = x.getCourseName();
            if (y.equals(courseName)) {
                courseList.remove(courseList.indexOf(x));
                // indexOf will return the index number, and with that we can remove an element by using the Index number.
                updateAndGetGPA();
                return;
            }
        }
        
        
        updateAndGetGPA();
    }
    
    public double updateAndGetGPA() {
        double gradeValue = 0;
        double totalPts = 0;
        double totalCredit = 0;
        
        Iterator<Course> iterate = courseList.iterator();
        
        while(iterate.hasNext()) {
            Course x = iterate.next();
            String y = x.getGrade();
            int z = x.getCredit();
            if (y.equals("A+")){
                gradeValue = 4.00;
            } else if (y.equals("A")) {
                gradeValue = 3.75;
            } else if (y.equals("B+")) {
                gradeValue = 3.50;
            } else if (y.equals("B")) {
                gradeValue = 3.00;
            } else if (y.equals("C+")) {
                gradeValue = 2.75;
            } else if (y.equals("C")) {
                gradeValue = 2.50;
            } else if (y.equals("D+")) {
                gradeValue = 2;
            } else if (y.equals("D")) {
                gradeValue = 1.75;
            }
            
            
            totalPts += (gradeValue*z);
        }
        
        Iterator<Course> iterate2 = courseList.iterator();
        
        while(iterate2.hasNext()) {
            Course x = iterate2.next();
            int z = x.getCredit();
            totalCredit += z;
        }
        
        GPA = totalPts / totalCredit;
        
        return GPA;
        
    }
    
    
    public String toString(){
        updateAndGetGPA();
        String ret = "Name of student: " + name + "\nThe ID: " + id + "\nThe GPA: " + getGPA() + "\nThe Courses has taken: \n";
        
        for (int i = 0; i < courseList.size(); i++){
            ret += courseList.get(i);
            // we are concatenate the object with the main string (ret)
        }
        
        return ret;
    }
    
}
