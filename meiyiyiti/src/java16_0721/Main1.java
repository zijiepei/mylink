package java16_0721;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String[] array = s1.split("_");
            String result = array[0];
            for(int i = 1;i < array.length;i++) {
               array[i] = array[i].toUpperCase().substring(0,1) + array[i].substring(1);
               result += array[i];
            }
            System.out.println(result);
        }
    }
}
