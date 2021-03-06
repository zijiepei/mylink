package java16_0604;

import java.util.Scanner;

public class BagLess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(count(scanner.nextInt()));
        }
    }

    private static int count(int n) {
        if(n < 6 || n == 10 || n % 2 != 0) {
            return -1;
        }
        if(n % 8 == 0) {
            return n / 8;
        }
        return  n / 8 + 1;
    }
}
