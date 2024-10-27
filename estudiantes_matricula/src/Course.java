import java.util.Set;
import java.util.TreeSet;

public class Course {
    private String courseName;
    private Set<Student> students;

    // Constructor para inicializar el curso
    public Course(String courseName) {
        this.courseName = courseName;
        // Crear el TreeSet con un Comparator explícito
        this.students = new TreeSet<>(new StudentNameComparator());
    }

    // Getter para el nombre del curso
    public String getCourseName() {
        return courseName;
    }

    // Método para agregar un estudiante al curso
    public void addStudent(Student student) {
        if (students.add(student)) {
            System.out.println("Estudiante agregado: " + student);
        } else {
            System.out.println("El estudiante ya está inscrito en el curso: " + student);
        }
    }

    // Método para listar los estudiantes inscritos en el curso
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes inscritos en el curso " + courseName);
        } else {
            System.out.println("Estudiantes inscritos en el curso " + courseName + ":");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}