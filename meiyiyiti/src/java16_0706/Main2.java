package java16_0706;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String string1 = scanner.next();
            int linenum = scanner.nextInt();
            String[] array = string1.split("\\\\");
            String s = array[array.length - 1];
            if(s.length() > 16) {
                s = s.substring(s.length() - 16);
            }
            String key = s + " " + linenum;
            int value = 1;
            if(map.containsKey(key)) {
                map.put(key,map.get(key) + 1);
            }else {
                map.put(key,value);
            }
        }
        int count = 0;
        for(String string : map.keySet()) {
            count++;
            if(count > (map.keySet().size() - 8)) {
                System.out.println(string + " " + map.get(string));
            }
        }
    }
}
