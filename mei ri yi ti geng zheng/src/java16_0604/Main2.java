package java16_0604;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            char[] array = string1.toCharArray();
            for(int i = 0;i < array.length;i++) {
                char c = string1.charAt(i);
                if(!string2.contains(String.valueOf(c))) {
                    System.out.print(c);
                }
            }
        }
    }
}
