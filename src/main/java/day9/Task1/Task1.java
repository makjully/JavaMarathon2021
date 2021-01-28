package day9.Task1;

public class Task1 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Иванов Иван Иванович", "Информатика");
        Student student = new Student("Федоров Олег", "ПИ175");

        System.out.println("Учебная группа объекта-студента: " + student.getGroupName());
        System.out.println("Учебная дисциплина преподавателя: " + teacher.getSubjectName());

        student.printInfo();
        teacher.printInfo();
    }
}
