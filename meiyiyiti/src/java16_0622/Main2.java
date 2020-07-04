package java16_0622;


import java.util.*;

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int stuNum = scanner.nextInt();
            int num = scanner.nextInt();
            List<Student> studentList = new ArrayList<>();
            for(int i = 0;i < stuNum;i++) {
                studentList.add(new Student(scanner.next(),scanner.nextInt()));
            }
        if(num == 0){
            Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o2.score - o1.score;
                }
            });
           }
        if(num == 1) {
            Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.score - o2.score;
                }
            });
        }
        for(int i = 0;i < studentList.size();i++) {
            System.out.println(studentList.get(i).name + " " + studentList.get(i).score);
        }
        }
    }
}