public class StudentCourseApp {

    public static void main(String[] args) {
        Student osama = new Student("osama", 443007698);
        
        
        osama.addCourse("CSI", "A+", "Spring 2021", 4);
        osama.addCourse("Quran", "A", "Spring 2022", 2);
        osama.addCourse("Physics", "C", "Summer 2021", 3);
        osama.addCourse("Calculas", "B", "Fall 2020", 4);
        
        
        Student mahdi = new Student("mahdi", 443007777, osama);
        
        
        
        
        System.out.println(osama);
        osama.removeCourse("Calculas");
        System.out.println("after deleteing -----------------\n\n");
        
        System.out.println(osama);
        
        System.out.println(mahdi);
        
    }
}
