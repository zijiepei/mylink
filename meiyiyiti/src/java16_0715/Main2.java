package java16_0715;

import java.util.Scanner;

public class Main2 {
    public static boolean isHuiWen(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        return stringBuffer.reverse().toString().equals(s);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            if(string.length() > 10) {
                System.out.println("NO");
                return;
            }
            boolean ret = isHuiWen(string);
            if(ret == true) {
                System.out.println("YES");
            }else {
                int i = 0;
                while (i < string.length()) {
                    StringBuffer sb = new StringBuffer(string);
                    boolean ret2 = isHuiWen(sb.deleteCharAt(i).toString());
                    if(ret2 == true) {
                        System.out.println("YES");
                        return;
                    }else {
                        i++;
                    }
                }
                System.out.println("NO");
            }
        }
    }
}
