package java16_0625;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String string2 = scanner.nextLine();
            List<Character> list = new LinkedList<>();
            for(int i = 0;i < string.length();i++) {
                char c = string.charAt(i);
                list.add(c);
            }
            int count = 0;
            for(int i = 0; i < string2.length();i++) {
                char c = string2.charAt(i);
                for(int j = 0;j < list.size();j++) {
                    if(c == list.get(j)) {
                        count++;
                        list.remove(j);
                        break;
                    }
                }
            }
            if(count == string2.length()) {
                System.out.println("Yes" + (string.length() - count));
            }else {
                System.out.println("No" + (string2.length() - count));
            }
        }
    }
}
