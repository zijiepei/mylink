package java16_0610;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = 0;
        if(n == 0) {
            System.out.println(ret);
        }
        while (n > 0) {
             ret = n % 10;
            System.out.print(ret);
             n /= 10;
        }
    }
}
