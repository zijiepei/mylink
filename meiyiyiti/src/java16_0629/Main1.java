package java16_0629;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array1 = new int[n];
            for (int i = 0; i < n; i++) {
                array1[i] = scanner.nextInt();
            }
            int[] array2 = new int[n];
            for(int i = 0;i < n;i++) {
                array2[i] = scanner.nextInt();
            }
            float sum = 0;
            int score = 0;
            for(int i = 0;i < n;i++) {
                score += array1[i];
                if(90 <= array2[i] && array2[i] <= 100) {
                    sum += 4.0 * array1[i];
                }else if(85 <= array2[i] && array2[i] <= 89) {
                    sum += 3.7 * array1[i];
                }else if(82 <= array2[i] && array2[i] <= 84) {
                    sum += 3.3 * array1[i];
                }else if(78 <= array2[i] && array2[i] <= 81) {
                    sum += 3.0 * array1[i];
                }else if(75 <= array2[i] && array2[i] <= 77) {
                    sum += 2.7 * array1[i];
                }else if(72 <= array2[i] && array2[i] <= 74) {
                    sum += 2.3 * array1[i];
                }else if(68 <= array2[i] && array2[i] <= 71) {
                    sum += 2.0 * array1[i];
                }else if(64 <= array2[i] && array2[i] <= 67) {
                    sum += 1.5 * array1[i];
                }else if(60 <= array2[i] && array2[i] <= 63) {
                    sum += 1.0 * array1[i];
                }else if(array2[i] < 60) {
                    sum += 0.1 * array1[i];
                }
            }
            System.out.printf("%.2f",sum / score);
        }
    }
}
