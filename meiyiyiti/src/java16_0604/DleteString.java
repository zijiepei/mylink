package java16_0604;

import java.util.Scanner;

public class DleteString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] array = scanner.nextLine().toCharArray();
            String string = scanner.nextLine();
            for(int i = 0;i < array.length;i++) {
                char c = array[i];
                if(!string.contains(String.valueOf(c))) {
                    System.out.print(c);
                }
            }
        }
    }
}
