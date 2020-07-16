package java16_0716;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            StringBuffer stringBuffer = new StringBuffer(string1);
            for(int i = 0;i < string2.length();i++) {
                char c = string2.charAt(i);
                for(int j = 0;j < stringBuffer.length();j++) {
                    char a = stringBuffer.charAt(j);
                    if(c == a) {
                        stringBuffer.deleteCharAt(j);
                    }
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
