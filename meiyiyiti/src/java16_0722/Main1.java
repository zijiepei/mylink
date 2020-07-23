package java16_0722;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] s = string.split(" ");
            List<Character> list = new ArrayList<>();
            for(int i = 0;i < s[0].length();i++) {
                char c = s[0].charAt(i);
                list.add(c);
            }
            int i = 0;
            for(i = 0;i < s[1].length();i++) {
                char c = s[1].charAt(i);
                if(list.contains(c)) {
                    for(int j = 0;j < list.size();j++) {
                        if(c == list.get(j)) {
                            list.remove(j);
                            break;
                        }
                    }
                }else {
                    System.out.println("No");
                    break;
                }
            }
            if(i == s[1].length()) {
                System.out.println("Yes");
            }
        }
    }
}
