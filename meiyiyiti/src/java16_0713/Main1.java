package java16_0713;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < n;i++) {
                String s = scanner.nextLine();
                String[] s1 = s.split(" ");
                int m = Integer.parseInt(s1[0]);
                int a = Integer.parseInt(s1[1]);
                if(m == 1) {
                    list.add(a);
                }else {
                    for(int j = 0;j < list.size();j++) {
                        if(list.get(j) == a) {
                            list.remove(j);
                            break;
                        }
                    }
                }
                if(i < 2) {
                    System.out.println("No");
                    continue;
                }
                int sum = 0;
                int max = 0;
                for(int j = 0;j < list.size();j++) {
                    sum += list.get(j);
                    if(list.get(j) > max) {
                        max = list.get(j);
                    }
                }
                if(sum - max > max) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }

    }
}
