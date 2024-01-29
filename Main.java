import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
}

class AcademicRecord {
    Course course;
    int grade;

    public AcademicRecord(Course course, int grade) {
        this.course = course;
        this.grade = grade;
    }

    public String toString() {
        return course.courseCode + " - " + course.courseName + ": Grade - " + grade;
    }
}

class AdministrativeInfo {
    String contactNumber;
    String address;

    public AdministrativeInfo(String contactNumber, String address) {
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String toString() {
        return "Contact Number: " + contactNumber + "\nAddress: " + address;
    }
}

class Student {
    String studentId;
    String firstName;
    String lastName;
    List<Course> enrolledCourses;
    List<AcademicRecord> academicRecords;
    AdministrativeInfo adminInfo;

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrolledCourses = new ArrayList<>();
        this.academicRecords = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void addAcademicRecord(Course course, int grade) {
        academicRecords.add(new AcademicRecord(course, grade));
    }

    public void setAdministrativeInfo(String contactNumber, String address) {
        this.adminInfo = new AdministrativeInfo(contactNumber, address);
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println(course.courseCode + " - " + course.courseName);
        }
        System.out.println("\nAcademic Records:");
        for (AcademicRecord record : academicRecords) {
            System.out.println(record.toString());
        }
        if (adminInfo != null) {
            System.out.println("\nAdministrative Information:");
            System.out.println(adminInfo.toString());
        }
        System.out.println();
    }
}

class Main {
    List<Student> students;

    public Main() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.studentId.equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Main sis = new Main();

        Student student1 = new Student("S001", "John", "Paul");
        Student student2 = new Student("S002", "David", "Smith");
        Student student3 = new Student("S003", "Ram", "Saran");
        Student student4 = new Student("S004", "Ramya", "Pandian");
        
        Course course1 = new Course("C001", "Java Programming");
        Course course2 = new Course("C002", "Database Management");
        Course course3 = new Course("C003", "Python Programming");
        Course course4 = new Course("C004", "Internet Of Things");
        Course course5 = new Course("C005", "Data Structures");

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student1.enrollCourse(course5);
        student2.enrollCourse(course3);
        student3.enrollCourse(course2);
        student3.enrollCourse(course4);
        student4.enrollCourse(course1);
        student4.enrollCourse(course5);

        student1.addAcademicRecord(course1, 90);
        student1.addAcademicRecord(course2, 85);
        student1.addAcademicRecord(course5, 79);
        student2.addAcademicRecord(course3, 89);
        student3.addAcademicRecord(course2, 85);
        student3.addAcademicRecord(course4, 96);
        student4.addAcademicRecord(course1, 93);
        student4.addAcademicRecord(course5, 97);
        
        student1.setAdministrativeInfo("123-456-7890", "123 Main St, Chennai");
        student2.setAdministrativeInfo("126-436-1690", "Fleet Street, Coimbatore");
        student3.setAdministrativeInfo("769-329-6193", "Main Road, Trichy");
        student4.setAdministrativeInfo("782-993-1782", "Park Avenue, Tirupati");

        sis.addStudent(student1);
        sis.addStudent(student2);
        sis.addStudent(student3);
        sis.addStudent(student4);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to view information: ");
        String inputId = scanner.nextLine();

        Student foundStudent = sis.findStudentById(inputId);
        if (foundStudent != null) {
            foundStudent.displayInfo();
        } else {
            System.out.println("Student not found.");
        }
    }
}