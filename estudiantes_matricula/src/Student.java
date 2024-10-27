import java.util.Objects;

public class Student {
    private String studentId;
    private String name;
    private String email;

    // Constructor para inicializar todos los campos
    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    // Getters para cada campo
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Método toString() para retornar una representación en cadena del estudiante
    @Override
    public String toString() {
        return "ID: " + studentId + ", Nombre: " + name + ", Email: " + email;
    }

    // Método equals() para comparar dos estudiantes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    // Método hashCode() para generar un código hash basado en studentId
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}