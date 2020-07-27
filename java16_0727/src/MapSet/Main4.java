package MapSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expected = scanner.nextLine().toUpperCase();
            String actual = scanner.nextLine().toUpperCase();
            Set<Character> set = new HashSet<>();
            for(int i = 0;i < actual.length();i++) {
                set.add(actual.charAt(i));
            }
            Set<Character> broken = new HashSet<>();
            for(int i = 0;i < expected.length();i++) {
                char c = expected.charAt(i);
                if(set.contains(c)) {
                    continue;
                }
                if(broken.contains(c)) {
                    continue;
                }
                System.out.print(c);
                broken.add(c);
            }
        }
    }
}
