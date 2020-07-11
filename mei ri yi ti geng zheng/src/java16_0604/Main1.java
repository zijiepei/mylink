package java16_0604;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(count(scanner.nextInt()));
        }
    }

    private static int count(int n) {
        if(n % 2 != 0 || n < 6 || n == 10) {
            return -1;
        }
        if(n % 8 == 0) {
            return n / 8;
        }
        return n / 8 + 1;
    }
}
