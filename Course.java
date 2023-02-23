public class Course {

    private String courseName;
    private String grade;
    private String semesterName;
    private int credit;
    
    
    public Course() {
        this("unknown", "unknown", "unknown", 0);
    }
    
    public Course(String courseName) {
        this(courseName, "unknown", "unknown", 0);
    }
    
    public Course(String courseName, String grade, String semesterName, int credit) {
        this.courseName = courseName;
        this.grade = grade;
        this.semesterName = semesterName;
        this.credit = credit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public String toString(){
        return "\tThe course name: " + courseName + "\n\tThe grade: " + grade + "\n\tSemester Name: " + semesterName + "\n\n";
    }

}
