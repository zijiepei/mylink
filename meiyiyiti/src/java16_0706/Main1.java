package java16_0706;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] strings = string.split(" ");
            String[] strings2 = new String[strings.length];
            int i = strings.length - 1;
            int j = 0;
            for(;i >= 0;i--) {
                for(;j <= strings.length - 1;j++) {
                    strings2[j] = strings[i];
                    System.out.print(strings2[j] + " ");
                    break;
                }
            }
        }
        scanner.close();
    }
}
