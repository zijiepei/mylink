package Array;

import java.util.Arrays;
import java.util.Stack;

public class ArrSort2 {
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        //insertSort(array);
        //shellSort(array);
        //slectSort(array);
        //bubbleSort(array);
        //quickSort(array);
        //heapSort(array);
        //mergSort(array);
        quickSortByloop(array);
        System.out.println(Arrays.toString(array));
    }
    public static void insertSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for(cur = bound - 1;cur >= 0;cur--) {
                if(array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertGap(array,gap);
            gap = gap / 2;
        }
        insertGap(array,1);
    }

    private static void insertGap(int[] array, int gap) {
        for(int bound = gap;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for(cur = bound - gap;cur >= 0;cur = cur - gap) {
                if(array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }
    public static void slectSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = bound;cur < array.length;cur++) {
                if(array[cur] < array[bound]) {
                    swap(array,cur,bound);
                }
            }
        }
    }

    private static void swap(int[] array, int cur, int bound) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
    }
    public static void bubbleSort(int[] array) {
        for(int i = 0;i < array.length;i++) {
            for(int j = 0;j < array.length - 1 - i;j++) {
                if(array[j] > array[j + 1]) {
                    swap(array,j,j + 1);
                }
            }
        }
    }
    public static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
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
    public static void heapSort(int[] array) {
        creatHeap(array);
        int heapsize = array.length;
        for(int i = 0;i < array.length;i++) {
            swap(array,0,heapsize - 1);
            heapsize--;
            shiftDown(array,heapsize,0);
        }
    }

    private static void shiftDown(int[] array, int heapsize, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapsize) {
            if(child + 1 < heapsize && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                swap(array,parent,child);
            }else {
                break;
            }
        }
        parent = child;
        child = 2 * parent + 1;
    }

    private static void creatHeap(int[] array) {
        for(int i = (array.length - 1 - 1) / 2;i >= 0;i--) {
            shiftDown(array,array.length,i);
        }
    }
    public static void mergSort(int[] array) {
        mergSortHelper(array,0,array.length);
    }

    private static void mergSortHelper(int[] array, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergSortHelper(array,left,mid);
        mergSortHelper(array,mid,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outputSiae = 0;
            while (cur1 < mid && cur2 < right) {
                if(array[cur1] <= array[cur2]) {
                    output[outputSiae] = array[cur1];
                    cur1++;
                    outputSiae++;
                }else {
                    output[outputSiae] = array[cur2];
                    cur2++;
                    outputSiae++;
                }
            }
            while (cur1 < mid) {
                output[outputSiae] = array[cur1];
                cur1++;
                outputSiae++;
            }
            while (cur2 < right) {
                output[outputSiae] = array[cur2];
                cur2++;
                outputSiae++;
            }
        for(int i = 0;i < right - left;i++) {
            array[left + i] = output[i];
        }
    }
    public static void quickSortByloop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                continue;
            }
            int index = patition(array,left,right);
            stack.push(index + 1);
            stack.push(right);
            stack.push(left);
            stack.push(index - 1);
        }
    }
}
