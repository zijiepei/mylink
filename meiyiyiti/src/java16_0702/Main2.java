package java16_0702;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if(checklength(s) && checkcharkind(s) && checkrepeat(s)) {
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }

    private static boolean checkrepeat(String s) {
        for (int i = 0;i < s.length() - 2;i++) {
            String s1 = s.substring(i,i + 3);
            if(s.substring(i+1).contains(s1)){
                return false;
            }
        }
        return true;
    }

    private static boolean checkcharkind(String s) {
        int uppercase = 0, lowercase = 0, digtial = 0, other = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lowercase = 1;
                continue;
            } else if (c >= 'A' && c <= 'Z') {
                uppercase = 1;
                continue;
            } else if (c >= '0' && c <= '9') {
                digtial = 1;
                continue;
            } else {
                other = 1;
                continue;
            }
        }
        return (uppercase + lowercase + digtial + other) >= 3;
    }

    private static boolean checklength(String s) {
        if(s == null || s.length() <= 8) {
            return false;
        }else {
            return true;
        }
    }
}
