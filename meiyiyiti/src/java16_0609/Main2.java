package java16_0609;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] array = string.split(" ");
        int[] num = new int[array.length - 1];
        for(int i = 0;i < array.length - 1;i++) {
            num[i] = Integer.parseInt(array[i]);
        }
        int k = Integer.parseInt(array[array.length - 1]);
        Arrays.sort(num);
        for(int j = 0;j < k;j++) {
            System.out.print(num[j]);
            if(j < k - 1) {
                System.out.print(" ");
            }
        }
    }
}
