package java16_0726;

import java.util.Arrays;

public class Main1 {
    public static int findMaxGap(int[] A, int n) {
        n = A.length;
        int max = 0;
        for(int i = 0;i <= n - 2;i++) {
            int[] array = Arrays.copyOfRange(A,0,i + 1);
            int[] array2 = Arrays.copyOfRange(A,i + 1,n);
            Arrays.sort(array,0,array.length);
            Arrays.sort(array2,0,array2.length);
            int m = array[array.length - 1] - array2[array2.length - 1];
            if(m < 0) {
                m = (-1) * m;
            }
            if(m > max) {
                max = m;
            }
        }
        return max;
    }
}
