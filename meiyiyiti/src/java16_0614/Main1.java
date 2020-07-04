package java16_0614;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c = 0;
        while (N > c) {
           c = a + b;
           a = b;
           b = c;
        }
        int count1 = N - a;
        int count2 = b - N;
        if(count1 > count2) {
            System.out.println(count2);
        }else {
            System.out.println(count1);
        }
    }
}
