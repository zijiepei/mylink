package java16_0602;

public class AntiOrder {
    public int count(int[] A, int n) {
        if(n == 0 || n == 1) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i <= n - 2;i++) {
            for(int k = i + 1;k < A.length;k++) {
                if(A[i] > A[k]) {
                    count++;
                }
            }
        }
        return count;
    }
}
