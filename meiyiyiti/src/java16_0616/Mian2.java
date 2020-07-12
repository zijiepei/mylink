package java16_0616;

import java.util.Arrays;
import java.util.Scanner;

public class Mian2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String sum = "";
            int j = n * n - n + 1;
            for(int i = 1;i <= n;i++) {
                if(i == n) {
                  sum = sum + j;
                  break;
                }
                sum = sum + j + "+";
                j = j + 2;
            }
            System.out.println(sum);
        }
    }
}
