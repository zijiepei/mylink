package java16_0717;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for(int i = 0;i < n;i++) {
                array[i] = scanner.nextInt();
            }
            int sum = array[0];
            int max = array[0];
            for(int i = 1;i < n;i++) {
                if(sum >= 0) {
                    sum += array[i];
                }else {
                    sum = array[i];
                }
                if(sum > max) {
                    max = sum;
                }
            }
            System.out.println(max);
        }
    }
}
