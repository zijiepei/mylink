package java16_0711;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            for(char i = 'A';i <= 'Z';i++) {
                int count = 0;
                for(int j = 0; j < string.length();j++) {
                    char c = string.charAt(j);
                    if(c == i) {
                        count++;
                    }
                }
                map.put(i,count);
                count = 0;
            }
            for(Map.Entry<Character,Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
