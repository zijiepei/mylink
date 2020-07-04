package java16_0615;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String s = scanner.next();
        int hang = (N + 1) / 2;
        for(int i = 0;i < N;i++) {
            System.out.print(s);
        }
        System.out.println();
        if(hang == 2) {
            for(int i = 0;i < N;i++) {
                System.out.print(s);
            }
        }else {
            String ret = "";
            ret += s;
            for(int n = 0;n < N - 2;n++) {
                ret += " ";
            }
            ret += s;
            for(int i = 0;i < hang - 2;i++) {
                System.out.println(ret);
            }
            for(int i = 0;i < N;i++) {
                System.out.print(s);
            }
        }
    }
}
