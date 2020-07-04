package java16_0604;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DleteString {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.next();
        String string2 = scanner.next();
        char[] charString1 = string1.toCharArray();
        for (int i = 0; i < string2.length(); i++) {
            set.add(string2.charAt(i));
        }
        for(int j = 0;j < charString1.length;j++) {
            if(set.contains(charString1[j])) {

            }
        }

    }
}
