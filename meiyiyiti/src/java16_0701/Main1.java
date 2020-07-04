package java16_0701;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array1 = new int[n];
            for(int i = 0;i < n;i++) {
                array1[i] = scanner.nextInt();
            }
            int x = scanner.nextInt();
            int ret = 0;
            for(int i = 0; i < n;i++) {
                if(array1[i] == x) {
                    ret = i;
                    break;
                }else {
                    ret = -1;
                }
            }
            System.out.println(ret);
        }
        scanner.close();
    }
}
