package java16_0620;

public class Main2 {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 1;
        int ret = 1;
        for(int i = 1; i <= 30;i++) {
            num1 += 10;
        }
        for(int i = 1; i <= 29;i++) {
            ret *= 2;
            num2 = num2 + ret;
        }
        System.out.print(num1 + " " + num2);
    }
}
