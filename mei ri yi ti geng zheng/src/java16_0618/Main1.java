package java16_0618;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        while (group-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] res = new int[2*n];
            for(int i = 0;i < 2*n;i++) {
                int tmp = i + 1;
                for(int j = 0;j < k;j++) {
                    if(tmp <= n) {
                        tmp = 2 * tmp - 1;
                    }else {
                        tmp = 2 * (tmp - n);
                    }
                }
                res[tmp - 1] = scanner.nextInt();
            }
            if(res.length > 0) {
                System.out.print(res[0]);
            }
            for(int i = 1;i < res.length;i++) {
                System.out.print(" " + res[i]);
            }
            System.out.println();
        }
    }
}
