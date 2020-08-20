package JZ7;

public class Main1 {
    public int Fibonacci(int n) {
        int i = 0;
        int j = 1;
        if(n == 0) {
            return i;
        }
        if(n == 1) {
            return j;
        }
        int fab = -10;
        for(int a = 2;a <= n;a++) {
            fab = i + j;
            i = j;
            j = fab;
        }
        return fab;
    }
}
