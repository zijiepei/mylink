package java16_0612;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            char[] array = string.toCharArray();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < 10;i++) {
                list.add(0);
            }
            for(int i = 0;i < array.length;i++) {
                list.set(array[i] - '0',list.get(array[i] - '0') + 1);
            }
            for(int i = 0;i < list.size();i++) {
                if(list.get(i) > 0) {
                    System.out.println(i + ":" + list.get(i));
                }
            }
        }
    }
}
