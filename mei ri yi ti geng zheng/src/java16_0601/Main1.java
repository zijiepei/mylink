package java16_0601;

import java.util.Scanner;

public class Main1 {
    public static boolean judgeHuiwen(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        return stringBuffer.reverse().toString().equals(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int count = 0;
            for(int i = 0;i <= a.length();i++) {
                StringBuffer stringBuffer = new StringBuffer(a);
                stringBuffer.insert(i,b);
                if(judgeHuiwen(stringBuffer.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
