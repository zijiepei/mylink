package java16_0610;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = 0;
        for(int i = n;i >= 5;i--) {
            int tmp = i;
            while (tmp % 5 == 0) {
                ret++;
                tmp /= 5;
            }
        }
        System.out.println(ret);
    }
}
