package java16_0703;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            double num1 = allSort(n);
            double num2 = Count(n);
            double result = (num2 / num1) * 100;
            System.out.println(String.format("%.2f",result) + "%");
        }
    }

    private static double Count(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }else {
            return (n - 1) * (Count(n - 1) + Count(n - 2));
        }
    }

    private static double allSort(int n) {
        double ret = 1;
        while (n > 1) {
            ret = ret * n;
            n = n - 1;
        }
        return ret;
    }
}
