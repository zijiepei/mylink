package java16_0603;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();////////////////////此处必须按行处理,因为可能中间会有用空格断开的字符串
            int max = 0;
            int count = 0;
            int end = 0;
            for(int i = 0;i < string.length();i++) {
                char c = string.charAt(i);
                if(c >= '0' && c <= '9') {
                    count++;
                    if(max < count) {
                        max = count;
                        end = i;
                    }
                }else {
                    count = 0;
                }
            }
            System.out.println(string.substring(end - max + 1,end + 1));
        }
    }
}
