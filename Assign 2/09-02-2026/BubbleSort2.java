package Capgg;
class Student7 {
    String name;
    int roll;
    Student7(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
}
public class BubbleSort2 {
    public static void main(String[] args) {
        Student7[] students = {
            new Student7("Abc", 7),
            new Student7("Def", 5),
            new Student7("Rtg", 18),
            new Student7("Cde", 1),
            new Student7("Ake", 2),
            new Student7("Frg", 13)
        };
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {

                if (students[j].roll > students[j + 1].roll) {
                    Student7 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by roll number:");
        for (Student7 s : students) {
            System.out.println(s.roll + " " + s.name);
        }
    }
}
