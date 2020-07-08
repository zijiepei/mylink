package java16_0707;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] P = scanner.next().split("\\.");
            String[] A = scanner.next().split("\\.");
            long num1 = 17 * 19, num2 = 19,num3 = 1;
            BigInteger num11 = BigInteger.valueOf(num1),num22 = BigInteger.valueOf(num2),num33 = BigInteger.valueOf(num3);
            BigInteger[] W = {num11,num22,num33};
            long[] a = {Long.parseLong(A[0]),Long.parseLong(A[1]),Long.parseLong(A[2])};
            long[] p = {Long.parseLong(P[0]),Long.parseLong(P[1]),Long.parseLong(P[2])};
            BigInteger[] a1 = {BigInteger.valueOf(a[0]),BigInteger.valueOf(a[1]),BigInteger.valueOf(a[2])};
            BigInteger[] p1 = {BigInteger.valueOf(p[0]),BigInteger.valueOf(p[1]),BigInteger.valueOf(p[2])};
            BigInteger ta = a1[0].multiply(W[0]) .add(a1[1].multiply( W[1])).add(a1[2].multiply( W[2]));
            BigInteger tp =p1[0].multiply(W[0]) .add(p1[1].multiply( W[1])).add(p1[2].multiply( W[2]));
            BigInteger tc = ta.subtract(tp);
            BigInteger zero = new BigInteger("0");
            if(tc.compareTo(zero) == -1) {
                System.out.print("-");
                tc = zero.subtract(tc);
            }
            System.out.println(tc .divide(W[0])  + "." + tc .mod(W[0]).divide(W[1])
                    + "." + tc.mod(W[0]).mod(W[1]).divide(W[2]));
        }
    }
}
