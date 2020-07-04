package java16_0601;

import java.util.Scanner;

public class CircleString {
    public static boolean judgeCircle(String c) {
         StringBuffer stringBuffer = new StringBuffer(c);
       return stringBuffer.reverse().toString().equals(c);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        int count = 0;
        for(int i = 0;i <= string1.length();i++) {
            StringBuffer stringBuffer = new StringBuffer(string1);
            stringBuffer.insert(i,string2);
            if(judgeCircle(stringBuffer.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
