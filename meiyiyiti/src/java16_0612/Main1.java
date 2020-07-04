package java16_0612;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner((System.in));
        int N = scanner.nextInt();
        while (N != 0) {
            int key = N % 10;
            Integer value = map.get(key);
            if(value == null) {
                map.put(key,1);
            }else {
                map.put(key,value + 1);
            }
            N /= 10;
        }
        for(int i = 0;i <= 9;i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() == i) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
            }
        }
    }
}
