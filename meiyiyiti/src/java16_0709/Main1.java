package java6_0709;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String except = scanner.nextLine();
            String actul = scanner.nextLine();
            except = except.toUpperCase();
            actul = actul.toUpperCase();
            Set<Character> setactul = new HashSet<>();
            for(int i = 0;i < actul.length();i++) {
                setactul.add(actul.charAt(i));
            }
            Set<Character> brokenkey = new HashSet<>();
            for(int i = 0;i < except.length();i++) {
                char c = except.charAt(i);
                if(setactul.contains(c)) {
                    continue;
                }
                if(brokenkey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenkey.add(c);
            }
        }
        scanner.close();
    }
}
