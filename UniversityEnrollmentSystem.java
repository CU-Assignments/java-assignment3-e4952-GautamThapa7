import java.util.*;

class Student {
    private String id;
    private String name;
    private List<String> enrolledCourses;
    
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }
    
    public void enrollCourse(String course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            System.out.println(name + " has enrolled in " + course);
        } else {
            System.out.println(name + " is already enrolled in " + course);
        }
    }
    
    public void dropCourse(String course) {
        if (enrolledCourses.remove(course)) {
            System.out.println(name + " has dropped " + course);
        } else {
            System.out.println(name + " is not enrolled in " + course);
        }
    }
}

class University {
    private Map<String, Student> students;
    
    public University() {
        this.students = new HashMap<>();
    }
    
    public void registerStudent(String id, String name) {
        if (!students.containsKey(id)) {
            students.put(id, new Student(id, name));
            System.out.println("Student " + name + " registered successfully.");
        } else {
            System.out.println("Student ID already exists.");
        }
    }
    
    public Student getStudent(String id) {
        return students.get(id);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        
        while (true) {
            System.out.println("\nUniversity Enrollment System");
            System.out.println("1. Register Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Student Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    university.registerStudent(id, name);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    Student student = university.getStudent(id);
                    if (student != null) {
                        System.out.print("Enter Course Name: ");
                        String course = scanner.nextLine();
                        student.enrollCourse(course);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    student = university.getStudent(id);
                    if (student != null) {
                        System.out.print("Enter Course Name: ");
                        String course = scanner.nextLine();
                        student.dropCourse(course);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    student = university.getStudent(id);
                    if (student != null) {
                        System.out.println("Student Name: " + student.getName());
                        System.out.println("Enrolled Courses: " + student.getEnrolledCourses());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
