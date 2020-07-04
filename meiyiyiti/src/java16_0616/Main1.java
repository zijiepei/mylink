package java16_0616;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        while (scanner.hasNext()) {
            for (int i = 0; i < 10; i++) {
                array[i] = scanner.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            for (int x = 0; x < 10; x++) {
                for (int i = 0; i < array[x]; i++) {
                    list.add(x);
                }
            }
            //到这里就把所有数字都拿到了
            int[] array1 = new int[list.size()];
            int y = 0;
            for (int x : list) {
                array1[y] = x;
                y++;
            }
            Arrays.sort(array1);
            if (array1[0] == 0) {
                for (int i = 1; i < array1.length; i++) {
                    if (array1[i] != 0) {
                        int tmp = array1[i];
                        array1[i] = array1[0];
                        array1[0] = tmp;
                        break;
                    }
                }
            }
            for (int i = 0; i < array1.length; i++) {
                System.out.print(array1[i]);
            }
        }
    }
}
