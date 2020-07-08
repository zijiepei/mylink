package java16_0708;

public class Main2 {
    public static int countWays(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 4;
        }
        int num1 = 1,num2 = 2,num3 = 4;
        int num = num1 + num2 + num3;
        int i = 4;
        while (i < n) {
            num1 = num2;
            num2 = num3;
            num3 = num;
            num = num1 + num2 + num3;
            i++;
        }
        int sum = num % 1000000007;
        return sum;
    }
    public static int countWays1(int n) {
        int[] a = new int[100001];
        a[0] = 0;
        a[1]=1;
        a[2]=2;
        a[3]=4;
        for(int i=4;i<=n;i++)
            a[i]=((a[i-1]+a[i-2])%1000000007+a[i-3])%1000000007;
        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(100000));
        System.out.println(countWays1(100000));
    }
}
