package java16_0606;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int[] array = new int[100];
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            array[n] = m;
            n++;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            Integer value = map.get(array[i]);
            if(value == null) {
                map.put(array[i],1);
            }else {
                map.put(array[i],value + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() >= (n / 2)) {
                System.out.print(entry.getKey());
            }
        }
    }
}
