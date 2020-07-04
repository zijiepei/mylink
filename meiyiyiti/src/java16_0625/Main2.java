package java16_0625;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            List<Character> list = new LinkedList<>();
            for(int i = 0;i < string1.length();i++) {
                char c = string1.charAt(i);
                list.add(c);
            }
            int count = 0;
            for(int i = 0;i < string2.length();i++) {
                char c = string2.charAt(i);
                for(int j = 0;j < list.size();i++) {
                    if(c == list.get(j)) {
                        count++;
                        list.remove(j);
                        break;
                    }
                }
            }
            if(count == string2.length()) {
                System.out.println("Yes" + " " + (string1.length() - count));
            }else {
                System.out.println("No" + " " + (string2.length() - count));
            }
        }
    }
}
