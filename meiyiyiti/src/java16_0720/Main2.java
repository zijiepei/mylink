package java16_0720;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 1;i <= n;i++) {
                arrayList.add(i);
                count(m,i,i,n,arrayList);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    private static void count(int m, int sum, int currentVal, int n, ArrayList<Integer> arrayList) {
        if(sum > m) {
            return;
        }
        if(sum == m) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                stringBuilder.append(iterator.next() + " ");
            }
            System.out.println(stringBuilder.toString().trim());
        }else {
            for(int i = currentVal + 1;i <= n;i++) {
                arrayList.add(i);
                count(m,sum + i,i,n,arrayList);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }
}
