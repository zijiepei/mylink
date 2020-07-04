package java16_0611;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c = a + b;
        while (N > c) {
            a = b;
            b = c;
            c = a + b;
        }
        int count1 = N - b;
        int count2 = c - N;
        if(count1 > count2) {
            System.out.println(count2);
        }else {
            System.out.println(count1);
        }
    }
}
