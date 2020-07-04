package java16_0626;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            for(int i = 0;i < N;i++) {
                array[i] = scanner.nextInt();
            }
            int A1 = 0;
            int count = 0;
            for(int x : array) {
                if(x % 5 == 0 && x % 2 == 0) {
                    A1 += x;
                }
            }

            int A2 = 0;
            int ret = 1;
            int sum = 0;
            for(int x : array) {
                if(x % 5 == 1) {
                  sum += ret * x;
                  ret *= -1;
                }
            }
            A2 = sum;

            int A3 = 0;
            int count3 = 0;
            for(int x : array) {
                if(x % 5 == 2) {
                    count3++;
                }
            }
            A3 = count3;

            String A4 = "";
            int sum2 = 0;
            int count4 = 0;
            for(int x : array) {
               if(x % 5 == 3) {
                   sum2 += x;
                   count4++;
               }
            }
            float A42 = (float)sum2 / count4;
            DecimalFormat num = new DecimalFormat("0.0");
            A4 = num.format(A42);

            int A5 = 0;
            int max = 0;
            for(int x : array) {
                if(x % 5 == 4) {
                   if(x > max) {
                       max = x;
                   }
                }
            }
            A5 = max;
            System.out.println(A1 + " " + A2 + " " + A3 + " " + A4 + " " + A5);
        }
    }
}
