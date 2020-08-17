package MapSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Student {
    public String name;
    public Integer age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
public class TestMap {
    public static void main(String[] args) {
        Map<String, Student> studentMap = new TreeMap<>();
        Student s1 = new Student("蔡徐坤", 30, "大二", "多人运动学院");
        Student s2 = new Student("蒋劲夫", 28, "大一", "拳王学院");
        Student s3 = new Student("汤神", 25, "大十", "比特科技");
        studentMap.put(s1.name, s1);
        studentMap.put(s2.name, s2);
        studentMap.put(s3.name, s3);
        Student s4 = new Student("汤神",300,"大100","比特科技");
        studentMap.put("汤神",s4);
        System.out.println(s3);
        System.out.println(s4);
        String name = "汤神";
        Student s5 = studentMap.get(name);
        System.out.println(s5);
        Iterator<Map.Entry<String,Student>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Student> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        /*Student student1 = studentMap.get("卡蜜尔");
        Student student2 = studentMap.getOrDefault("卡蜜尔",new Student("卡蜜尔",300,"大十","皮尔特沃夫"));
        System.out.println(student1);
        System.out.println(student2);
        Student student3 = new Student("卡蜜尔",301,"驻颜有方","岁月微痕");
        studentMap.put(student3.name,student3);
        System.out.println(student3);
        System.out.println(student2);*/
        /*<Integer, Student> map = new HashMap<>();
        map.put(s1.age, s1);
        map.put(s2.age, s2);
        map.put(s3.age, s3);
        Student student2 = map.get(30);
        System.out.println(student2);*/
    }
}
