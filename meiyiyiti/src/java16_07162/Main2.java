package java_07162;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for(int i = 0;i < n;i++) {
                array[i] = scanner.nextInt();
            }
            for(int i = 0;i < n;i++) {
                int tmp1 = -1;
                int tmp2 = -1;
                for(int j = i - 1;j >= 0;j--) {
                    if(array[j] < array[i]) {
                        tmp1 = j;
                        break;
                    }
                }
                for(int k = i + 1;k < n;k++) {
                    if(array[k] < array[i]) {
                        tmp2 = k;
                        break;
                    }
                }
                System.out.println(tmp1 + " " + tmp2);
            }
        }
    }
}
