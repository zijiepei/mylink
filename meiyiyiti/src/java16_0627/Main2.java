package java16_0627;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = null;
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            array1 = new int[N];
            for(int i = 0;i < array1.length;i++) {
                array1[i] = scanner.nextInt();
            }
            String c = "";
            for(int i = 0;i < M;i++) {
                c = scanner.next();
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                ChangeFound(c,A,B,array1);
            }

        }
    }
    private static void ChangeFound(String c, int a, int b,int[] array2) {
        if(c.charAt(0) == 'Q') {
            int end = Math.max(a, b);
            int begin = Math.min(a, b)-1;
            int max = array2[begin];
            for(int i=begin;i<end;i++){
                if(max<array2[i]){
                    max = array2[i];
                }
            }
            System.out.println(max);
        }
        if(c.charAt(0) == 'U') {
            array2[a - 1] = b;
        }
    }
}