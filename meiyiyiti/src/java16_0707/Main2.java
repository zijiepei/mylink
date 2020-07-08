package java16_0707;

import java.util.Scanner;

public class Main2 {
    public static int countNumberOf2s(int n) {
        int count = 0;
        for (int i = 1; n >= i; i = i * 10) {
            //count += n / (10 * i) * i;
            count += n / (10 * i) * i;
            int k = n % (10 * i);
            if (k >= 3 * i - 1) {
                count += i;
            }
            else if (k <= 2 * i - 1) {
                count += 0;
            }
            else {
                count += k - 2 * i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(10));
    }
}
