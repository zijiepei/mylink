package java_07162;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for(int i = 0;i < n;i++) {
                array[i] = scanner.nextInt();
            }
            int ret = 0;
            for(int x : array) {
                ret ^= x;
            }

            for(int i = 1;i <= 31;i += 2) {

            }
            for(int j = 2;j <= 30;j += 2) {

            }
        }
    }
}
