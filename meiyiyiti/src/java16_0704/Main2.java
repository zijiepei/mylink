package java16_0704;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         while (scanner.hasNext()) {
             int N = scanner.nextInt();
             BigInteger[] array = new BigInteger[N];
             for(int n = 0;n < N;n++) {
                 array[n] = scanner.nextBigInteger();
             }
             Arrays.sort(array);
             for(BigInteger x : array) {
                 System.out.println(x);
             }
         }
    }
}

