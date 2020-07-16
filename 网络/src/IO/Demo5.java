package IO;

import java.io.*;

class Student implements Serializable {
    public int age;
    public int score;
    public String name;

    public Student(int age, int score, String name) {
        this.age = age;
        this.score = score;
        this.name = name;
    }
}
public class Demo5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
     Student student = new Student(19,100,"asd");
     //xuliehua(student);
        Student student1 = fanxulie();
        System.out.println(student1.age + " " + student1.score + " " + student1.name);
    }
    public static void xuliehua(Student student) throws IOException {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("g:/text.txt"));
        objectOutputStream.writeObject(student);
    }
    public static Student fanxulie() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream("g:/text.txt"));
       Student student = (Student) objectInputStream.readObject();
       return student;
    }
}
