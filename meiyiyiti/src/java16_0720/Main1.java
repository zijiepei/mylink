package java16_0720;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            String number="222333444555666777788899991234567890";
            Set<String> set = new HashSet<>();
            for(int i = 0;i < n;i++) {
                String string = scanner.nextLine();
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = string.replace("-","");
                if(string2.length() > 7) {
                    continue;
                }
                for(int j = 0;j < string2.length();j++) {
                    char c = string2.charAt(j);
                    for(int m = 0;m < symbol.length();m++) {
                        if(j == 2 && c == symbol.charAt(m)) {
                            stringBuilder.append(number.charAt(m)).append('-');
                            break;
                        }else if(c == symbol.charAt(m)) {
                            stringBuilder.append(number.charAt(m));
                            break;
                        }
                    }
                }
                set.add(stringBuilder.toString());
            }
            List<String> list = new ArrayList<>();
            for(String s : set) {
                list.add(s);
            }
            Collections.sort(list);
            for(String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
