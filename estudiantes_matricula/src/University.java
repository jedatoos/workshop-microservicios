import java.util.HashMap;
import java.util.Map;

public class University {
    private Map<String, Course> courses; // Mapa para almacenar cursos, con el nombre del curso como clave

    // Constructor para inicializar la universidad
    public University() {
        this.courses = new HashMap<>();
    }

    // Método para agregar un curso
    public void addCourse(String courseName) {
        if (!courses.containsKey(courseName)) {
            courses.put(courseName, new Course(courseName));
        } else {
            System.out.println("El curso " + courseName + " ya está registrado.");
        }
    }

    // Método para obtener un curso por nombre
    public Course getCourse(String courseName) {
        return courses.get(courseName);
    }

    // Método para listar todos los cursos ofrecidos por la universidad
    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No hay cursos ofrecidos actualmente.");
        } else {
            System.out.println("Cursos ofrecidos:");
            for (String courseName : courses.keySet()) {
                System.out.println(courseName);
            }
        }
    }
}