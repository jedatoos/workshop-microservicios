public class Main {
    public static void main(String[] args) {
        // Crear una universidad
        University university = new University();

        // Agregar cursos a la universidad
        university.addCourse("Mathematics");
        university.addCourse("Physics");

        // Listar todos los cursos ofrecidos
        university.listCourses();

        // Obtener un curso
        Course mathCourse = university.getCourse("Mathematics");
        Course PhysycsCourse = university.getCourse("Physycs");

        // Crear algunos estudiantes
        Student student1 = new Student("123", "Alice", "alice@example.com");
        Student student2 = new Student("124", "Bob", "bob@example.com");
        Student student3 = new Student("124", "Bob", "bob@example.com");

        // Agregar estudiantes al curso de Matemáticas
        mathCourse.addStudent(student1);
        mathCourse.addStudent(student2);
        mathCourse.addStudent(student1); // Este estudiante ya está inscrito




        // Listar estudiantes del curso de Matemáticas
        mathCourse.listStudents();
    }
}