package java16_0606;

import java.util.Scanner;

public class Main1 {
        public static void main(String[] args) {
            float a, b, c, d;
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int num3 = scanner.nextInt();
                int num4 = scanner.nextInt();
                a = (num1 + num3) / 2f;
                b = (num3 - num1) / 2f;
                c = (num4 - num2) / 2f;
                if((a - ((num1+num3) / 2)) != 0) {
                    System.out.print("No");
                    return;
                }
                if((b - ((num3-num1) / 2) != 0) || (b != ((num2+num4) / 2))) {
                    System.out.print("No");
                    return;
                }
                if ((c - ((num4 - num2) / 2)) != 0) {
                    System.out.print("No");
                    return;
                }
                System.out.print((int) a + " " + (int) b + " " + (int) c);
            }
        }
    }
    
