package java16_0624;

import java.util.Scanner;

public class Main1 {

    public static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            int num = 1;
            System.out.println(num);
        }
        int i = 3;
        int m = 1;
        int n = 1;
        int num = 0;
        while (i <= monthCount) {
            num = m + n;
            m = n;
            n = num;
            i++;
        }
       return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(getTotalCount(num));
        }
    }
}
