package java16_0626;

public class Test {
    public static void main(String[] args) {
        int[] array = {5,10,15,21};
        int A2 = 0;
        int ret = 1;
        int sum = 0;
        for(int x : array) {
            if(x % 5 == 1) {
                sum += ret * x;
                ret *= -1;
            }
        }
        A2 = sum;
        System.out.println(A2);
    }
}
