package java16_0605;

import java.util.Scanner;

public class Main1 {
    static int[] weight;
    static int N;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            weight = new int[N + 1];
            for(int i = 1;i <= N;i++) {
                weight[i] = scanner.nextInt();
            }
            count(40,N);
            System.out.println(count);
        }
    }

    private static void count(int s, int n) {
        if (s == 0) {
            count++;
            return;
        }
        if(s < 0 || (s > 0 && n < 1)) {
            return;
        }
        count(s - weight[n],n - 1);
        count(s,n - 1);
    }
}
