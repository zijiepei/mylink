package java16_0606;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            int num4 = scanner.nextInt();
            if ((num1 + num3) % 2 == 0 && (num2 + num4) % 2 == 0 && (num4 - num2) % 2 == 0) {
                int A = num1 + num3 / 2;
                int B = num2 + num4 / 2;
                int C = num4 - num2 / 2;
                if (A >= 0 && B >= 0 && C >= 0) {
                    System.out.println(A + " " + B + " " + C);
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }
    }
}
