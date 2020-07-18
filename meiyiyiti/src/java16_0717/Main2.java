package java16_0717;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] array = string.split(";");
            int x = 0;
            int y = 0;
            for(String a : array) {
                if(a.length() != 3) {
                    continue;
                }
                if(a.charAt(0) == 'D' && a.substring(1).matches("[0-9]")){
                    x += Integer.parseInt(a.substring(1));
                }
                if(a.charAt(0) == 'W' && a.substring(1).matches("[0-9]")){
                    y += Integer.parseInt(a.substring(1));
                }
                if(a.charAt(0) == 'S' && a.substring(1).matches("[0-9]")){
                    y -= Integer.parseInt(a.substring(1));
                }
                if(a.charAt(0) == 'A' && a.substring(1).matches("[0-9]")){
                    x -= Integer.parseInt(a.substring(1));
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
