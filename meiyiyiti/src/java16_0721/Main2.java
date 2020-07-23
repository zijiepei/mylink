package java16_0721;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] array = string.split(" ");
            String[] array2 = new String[array.length];
            int i;
            int j = 0;
            for(i = array.length - 1;i >= 0;i--) {
                array2[j] = array[i];
                j++;
            }
            System.out.print(array2[0]);
            for(int k = 1;k <= array2.length - 1;k++) {
                System.out.print(" " + array2[k]);
            }
        }
    }
}
