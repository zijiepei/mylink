package java16_0630;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum1 = 0;
            int sum2 = 0;
            int n1 = n;
            int n2 = n * n;
            while (n1 != 0) {
                sum1 += n1 % 10;
                n1 /= 10;
            }
            while (n2 != 0) {
                sum2 += n2 % 10;
                n2 /= 10;
            }
            System.out.println(sum1 + " " + sum2);
        }
    }
}
