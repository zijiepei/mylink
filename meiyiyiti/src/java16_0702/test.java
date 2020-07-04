package java16_0702;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            if(String.valueOf(N * N).endsWith(String.valueOf(N))) {
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
}


