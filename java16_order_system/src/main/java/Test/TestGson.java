package Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGson {
   static class Student {
        private String name;
        private int id;
        private double score;

        public Student(String name, int id, double score) {
            this.name = name;
            this.id = id;
            this.score = score;
        }
    }
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();

        /*Student student = new Student("汤神",10,99.5);
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);*/
        String str = "{\"name\":\"汤神\",\"id\":10,\"score\":99.5}";
        Student s = gson.fromJson(str,Student.class);
        System.out.println(s.id + "," + s.name + "," + s.score);
    }
}
