package java16_0624;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String str2 = "VWXYZABCDEFGHIJKLMNOPQRSTU";
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0;i < string.length();i++) {
                char c = string.charAt(i);
                for(int j = 0;j < str1.length();j++) {
                    if(str1.charAt(j) == c) {
                        stringBuffer.append(str2.charAt(j));
                    }
                }
                if (c == ' '){
                    stringBuffer.append(' ');
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
