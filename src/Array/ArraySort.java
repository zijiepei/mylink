package Array;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        /*insertSort(array);
        insertSort2(array);
        insertSort3(array);*/
        /*shellSort(array);
        shellSort2(array);*/
        /*slectSort(array);
        System.out.println(Arrays.toString(array));*/
        //slectSort2(array);
        //bubbleSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = 0;cur < array.length - 1 - bound;cur++) {
                if(array[cur + 1] < array[cur]) {
                    swap(array,cur,cur + 1);
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        int index = patition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int patition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    private static void insertSort(int[] array) {
        for(int bound = 1;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for(;cur >= 0;cur--) {
                if(tmp < array[cur]) {
                   array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void insertSort2(int[] array) {
        for(int bound = 1;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for(cur = bound - 1;cur >= 0;cur--) {
                if(tmp < array[cur]) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void insertSort3(int[] array) {
        for(int bound = 1;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for(cur = bound - 1;cur >= 0;cur--) {
                if(tmp < array[cur]) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            shellSortHelp(array,gap);
            gap /= 2;
        }
        shellSortHelp(array,1);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSortHelp(int[] array, int gap) {
        for(int bound = gap;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for(cur = bound - gap;cur >= 0;cur = cur - gap){
                if(tmp < array[cur]) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }
    public static void shellSort2(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            shellSortHelp2(array,gap);
            gap /= 2;
        }
        shellSortHelp2(array,1);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSortHelp2(int[] array, int gap) {
        for(int bound = gap;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for(cur = bound - gap;cur >= 0;cur = cur - gap) {
                if(tmp < array[cur]) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }
    public static void swap(int[] array,int m,int n) {
        int tmp = array[m];
        array[m] = array[n];
        array[n] = tmp;
    }
    public static void slectSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = bound;cur < array.length;cur++) {
                if(array[bound] > array[cur]) {
                    swap(array,bound,cur);
                }
            }
        }
    }
    public static void slectSort2(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = bound;cur < array.length;cur++) {
                if(array[bound] > array[cur]) {
                    swap(array,bound,cur);
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
