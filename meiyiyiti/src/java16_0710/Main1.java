package java16_0710;

public class Main1 {
    public static void main(String[] args) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0;i < 30;i++) {
            sum1 += 10;
        }
        int n = 1;
        for(int i = 0;i < 30;i++) {
            sum2 += n;
            n *= 2;
        }
        System.out.print(sum1 + " " + sum2);
    }
}
