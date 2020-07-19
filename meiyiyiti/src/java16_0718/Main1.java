package java16_0718;

import java.util.Scanner;

public class Main1 {
   public static int iConverDateToDay(int year,int month,int day) {
           int sum = 0;
           int[] array = {0,31,28,31,30,31,30,31,31,30,31,30,31};
           if(month > 12 || month < 1) {
               return -1;
           }
           if(array[month] < day || day < 1) {
               return -1;
           }
           if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
               array[2] = 29;
               for(int i = month - 1;i >= 1;i--) {
                   sum += array[i];
               }
               sum += day;
           }else {
               for (int i = month - 1; i >= 1; i--) {
                   sum += array[i];
               }
               sum += day;
           }
           return sum;
   }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(iConverDateToDay(year,month,day));
        }
    }
}
