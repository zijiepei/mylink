import java.io.*;

class Student implements Serializable {
    public String name;
    public int age;
    public int score;
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}
public class IOdemo6  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Student student = new Student();
        student.name = "憨憨";
        student.age = 3;
        student.score = 60;*/
        //xuLieHuan(student);
        Student s = fanXuLie();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.score);
    }

    private static Student fanXuLie() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/student.txt"));
        Student student = (Student)objectInputStream.readObject();
        return student;
    }

    private static void xuLieHuan(Student student) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));
        objectOutputStream.writeObject(student);
    }

}
