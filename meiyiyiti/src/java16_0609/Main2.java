package java16_0609;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] a = s.toCharArray();
        int[] b = new int[a.length];
        int c = 0;
        for(int x : a) {
            b[c] = (int)x;
            c++;
        }
        Arrays.parallelSort(b,0,c - 1);
        int[] array2 = Arrays.copyOfRange(b,0,b[c]);
        System.out.println(Arrays.toString(array2));
    }
}
