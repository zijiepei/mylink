package ArraySort;

import java.util.Arrays;

public class Sorts {
    public static void insertSort(int[] array) {
        for(int bound = 1;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for(;cur >= 0;cur--) {
                if(array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void selectSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = bound;cur < array.length;cur++) {
                if(array[cur] < array[bound]) {
                    swap(array,bound,cur);
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = 0;cur < array.length - 1;cur++) {
                if(array[cur] > array[cur + 1]) {
                    swap(array,cur,cur + 1);
                }
            }
        }
    }
    private static void swap(int[] array, int bound, int cur) {
        int tmp = array[bound];
        array[bound] = array[cur];
        array[cur] = tmp;
    }

    public static void meregeSort(int[] arry) {
        meregeSortHelper(arry,0,arry.length);
    }

    private static void meregeSortHelper(int[] arry, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        meregeSortHelper(arry,0,mid);
        meregeSortHelper(arry,mid,right);
        merge(arry,left,mid,right);
    }

    private static void merge(int[] arry, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outoutsize = 0;
        while (cur1 < mid && cur2 < right) {
            if(arry[cur1] <= arry[cur2]) {
                output[outoutsize] = arry[cur1];
                outoutsize++;
                cur1++;
            }else {
                output[outoutsize] = arry[cur2];
                outoutsize++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            output[outoutsize] = arry[cur1];
            outoutsize++;
            cur1++;
        }
        while (cur2 < right) {
            output[outoutsize] = arry[cur2];
            outoutsize++;
            cur2++;
        }
        for(int i = 0; i < right - left;i++) {
            arry[left + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
