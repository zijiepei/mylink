package MapSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("c++");
        set.add("JS");
        System.out.println(set.contains("java"));
        set.remove("c++");
        System.out.println(set.contains("c++"));
        for (String s : set) {
            System.out.println(s);
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
