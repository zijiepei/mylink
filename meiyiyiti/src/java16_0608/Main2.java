package java16_0608;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int c = A;
        int d = B;
        int ret = 0;
        while ((ret = c % d) != 0 ) {
            c = d;
            d = ret;
        }
        System.out.println(A * B / d);
    }
}
