package java6_0709;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int z0 = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int z1 = scanner.nextInt();
            double r = Math.sqrt(Math.pow(x0-x1,2) + Math.pow(y0-y1,2) + Math.pow(z0-z1,2));
            double V = 4 / 3.0 * Math.acos(-1) * Math.pow(r,3);
            DecimalFormat format = new DecimalFormat("0.000");
            System.out.println(format.format(r) + format.format(V));
        }
    }
}
