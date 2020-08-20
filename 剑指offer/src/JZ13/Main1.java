package JZ13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1 {
    public static void reOrderArray(int [] array) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
       for(int i = 0;i < array.length;i++) {
           if (array[i] % 2 != 0) {
               queue1.offer(array[i]);
           } else {
               queue2.offer(array[i]);
           }
       }
           int i = 0;
           while (!queue1.isEmpty()) {
               array[i] = queue1.poll();
               i++;
           }
           while (!queue2.isEmpty()) {
               array[i] = queue2.poll();
               i++;
           }
       }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
