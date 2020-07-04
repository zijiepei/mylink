package java16_0602;

import java.util.Scanner;

public class DrinkMost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) {
                break;
            }
            int count = n / 2;
            System.out.println(count);
        }
    }
}
