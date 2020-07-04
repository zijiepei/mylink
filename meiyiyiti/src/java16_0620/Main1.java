package java16_0620;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static int[] arrayCopy(int[] count) {//1.for循环来拷贝数组;重新定义一个数组;使之一一对应
        int[] ret = new int[count.length];
        for(int i = 0;i < count.length;i++) {
            ret[i] = count[i];
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int m = scanner.nextInt();
        int[] count = new int[string.length() + 1 - m];
        for(int i = 0; i < string.length() + 1 - m;i++) {
            for(int j = i;j < i + m;j++) {
                char c = string.charAt(j);
                if(c == 'G' || c == 'C') {
                    count[i]++;
                }
            }
        }
        int[] array = arrayCopy(count);
        Arrays.sort(array);
        for(int i = 0; i < count.length;i++) {
            if(count[i] == array[array.length - 1]) {
                System.out.println(string.substring(i, i + m));
                break;
            }
        }
    }
}
