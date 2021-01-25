package day6;

public class Task3 {
    public static void main(String[] args) {
        Student student = new Student("Василий");
        Teacher teacher = new Teacher("Анна Ивановна", "биология");

        teacher.evaluate(student);
    }
}
