package java16_0618;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] array = new int[1000];
            int N = scanner.nextInt();
            if(N == 0) {
                return;
            }
                for (int i = 0; i < N; i++) {
                    int score = scanner.nextInt();
                    array[i] = score;
                }
                int flg = scanner.nextInt();
                int count = 0;
                for (int i = 0; i < N; i++) {
                    if (array[i] == flg) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }

