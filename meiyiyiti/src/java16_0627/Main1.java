package java16_0627;

import java.util.Scanner;

public class Main1 {
    public static int minNum(int a ,int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] array = new int[n];
            for(int i = 0;i < n;i++) {
                array[i] = scanner.nextInt();
            }
            for(int x : array) {
                if(a >= x) {
                    a += x;
                }
                if(a < x) {
                   a += minNum(a,x);
                }
            }
            System.out.println(a);
        }
        scanner.close();
    }
}
