package java16_0615;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            BigInteger a = new BigInteger(string1);
            BigInteger b = new BigInteger(string2);
            System.out.println(a.add(b));
        }
    }
}
