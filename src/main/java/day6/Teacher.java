package day6;

public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void evaluate(Student student) {
        int grade = 2 + (int) (Math.random() * ((5 - 2) + 1));
        String gradeValue = null;

        switch (grade) {
            case 5:
                gradeValue = "отлично";
                break;
            case 4:
                gradeValue = "хорошо";
                break;
            case 3:
                gradeValue = "удовлетворительно";
                break;
            case 2:
                gradeValue = "неудовлетворительно";
                break;
        }

        System.out.printf("Преподаватель %s оценил(а) студента с именем %s по предмету %s на оценку %s.",
                name, student.getName(), subject, gradeValue);
    }
}
