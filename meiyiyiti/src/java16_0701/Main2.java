package java16_0701;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String p = scanner.nextLine();
            iptoTen(ip);
            tentoIp(p);
        }
    }

    private static void tentoIp(String p) {
        Long tmp = Long.parseLong(p);
        String ip = Long.toBinaryString(tmp);
        StringBuffer stringBuffer = new StringBuffer();
        if(ip.length() < 32) {
            for(int i = 0;i < (32 - ip.length());i++) {
                stringBuffer.append(0);
            }
            stringBuffer.append(ip);
        }else {
            stringBuffer.append(ip);
        }
        for(int i=0;i<stringBuffer.length()-8;i=i+8){
            System.out.print(Integer.parseInt(stringBuffer.substring(i,i+8),2)+".");
        }
        System.out.println(Integer.parseInt(stringBuffer.substring(stringBuffer.length()-8,stringBuffer.length()),2));
    }

    private static void iptoTen(String ip) {
        String[] array = ip.split("\\.");
        Long n = Long.parseLong(array[0]);
        for(int i = 1;i < array.length;i++) {
            n = n << 8;
            n = n + Long.parseLong(array[i]);
        }
        System.out.println(n);
    }
}
