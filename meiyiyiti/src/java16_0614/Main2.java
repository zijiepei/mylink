package java16_0614;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] array = string.split(" ");
            for(int i = 0; i < array.length;i++) {
                set.add(array[i]);
            }
        }
        System.out.println(set.size());
    }
}
