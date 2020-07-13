package java16_0626;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuffer sb = new StringBuffer();
            int N = scanner.nextInt();
            int[] array = new int[N];
            for(int i = 0;i < N;i++) {
                array[i] = scanner.nextInt();
            }
            int A1 = 0;
            int count1 = 0;
            for(int x : array) {
                if(x % 5 == 0 && x % 2 == 0) {
                    A1 += x;
                    count1++;
                }
            }
            if(count1 == 0) {
                sb.append("N ");
            }else {
                sb.append(A1).append(" ");
            }

            int A2 = 0;
            int ret = 1;
            int sum = 0;
            int count2 = 0;
            for(int x : array) {
                if(x % 5 == 1) {
                    count2++;
                    sum += ret * x;
                    ret *= -1;
                }
            }
            A2 = sum;
            if(count2 == 0) {
                sb.append("N ");
            }else {
                sb.append(A2).append(" ");
            }

            int A3 = 0;
            int count3 = 0;
            for(int x : array) {
                if(x % 5 == 2) {
                    count3++;
                }
            }
            A3 = count3;
            if(count3 == 0) {
                sb.append("N ");
            }else {
                sb.append(A3).append(" ");
            }

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
            if(count4 == 0) {
                sb.append("N ");
            }else {
                sb.append(A4).append(" ");
            }
            int A5 = 0;
            int max = 0;
            int count5 = 0;
            for(int x : array) {
                if(x % 5 == 4) {
                    count5++;
                    if(x > max) {
                        max = x;
                    }
                }
            }
            A5 = max;
            if(count5 == 0) {
                sb.append("N");
            }else {
                sb.append(A5);
            }
            System.out.println(sb.toString());
        }
    }
}
