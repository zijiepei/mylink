package java16_0718;

import java.util.Scanner;

public class Main2 {
    public static String Encrypt(String s1) {
        String stringA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String string1 = "bcdefghijklmnopqrstuvwxyza";
        String stringB = stringA.toLowerCase();
        String string2 = string1.toUpperCase();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < s1.length();i++) {
            char c = s1.charAt(i);
            for(int j = 0;j < stringA.length();j++) {
                if(c == stringA.charAt(j)) {
                    stringBuffer.append(string1.charAt(j));
                }
            }
            for(int j = 0;j < stringB.length();j++) {
                if(c == stringB.charAt(j)) {
                    stringBuffer.append(string2.charAt(j));
                }
            }
        }
        return stringBuffer.toString();
    }
    public static String unEncrypt(String s1) {
        String stringA = "bcdefghijklmnopqrstuvwxyza";
        String string1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String stringB = stringA.toUpperCase();
        String string2 = string1.toLowerCase();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < s1.length();i++) {
            char c = s1.charAt(i);
            for(int j = 0;j < stringA.length();j++) {
                if(c == stringA.charAt(j)) {
                    stringBuffer.append(string1.charAt(j));
                }
            }
            for(int j = 0;j < stringB.length();j++) {
                if(c == stringB.charAt(j)) {
                    stringBuffer.append(string2.charAt(j));
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(Encrypt(s1));
            System.out.println(unEncrypt(s2));
        }
    }
}
