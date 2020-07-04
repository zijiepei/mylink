package java16_0630;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
            String[] array = s.split(" ");
            for(String s1 : array) {
                linkedHashMap.put(s1,0);
            }
            int n1 = scanner.nextInt();
            scanner.nextLine();
            String s2 = scanner.nextLine();
            String[] array1 = s2.split(" ");
            int invalidnum = 0;
            for(String s3 : array1) {
                if(linkedHashMap.containsKey(s3)) {
                    Integer value = linkedHashMap.get(s3);
                    if(value == null) {
                        linkedHashMap.put(s3,1);
                    }else {
                        linkedHashMap.put(s3,value + 1);
                    }
                }else {
                    invalidnum++;
                }
            }
            for(Map.Entry entry : linkedHashMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println("Invalid" + " : " + invalidnum);
        }
    }
}
