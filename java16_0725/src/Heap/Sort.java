package Heap;

import java.util.Arrays;
import java.util.Stack;

public class Sort {
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
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
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
    public static void selectSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = bound;cur < array.length;cur++) {
                if(array[cur] < array[bound]) {
                    swap(array,cur,bound);
                }
            }
        }
     }
    public static void heapSort(int[] array) {
        creatHeap(array);
        int heapSize = array.length;
        for(int i = 0;i < array.length;i++) {//////计数器
            swap(array,0,heapSize - 1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }

    public static void bubbleSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = 0;cur < array.length - 1 - bound;cur++) {
                if(array[cur] > array[cur + 1]) {
                    swap(array,cur,cur + 1);
                }
            }
        }
    }
    public static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(right <= left) {
            return;
        }
        int index = patition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }
    public static void quickSort2(int[] array) {
        quickSortHelper2(array,0,array.length - 1);
    }

    private static void quickSortHelper2(int[] array, int left, int right) {
        if(right <= left) {
            return;
        }
        int index = patition2(array,left,right);
        quickSortHelper2(array,left,index - 1);
        quickSortHelper2(array,index + 1,right);
    }
    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if(right <= left) {
                continue;
            }
            int index = patition(array,left,right);
            stack.push(index + 1);
            stack.push(right);
            stack.push(left);
            stack.push(index - 1);
        }
    }
    public static void quickSortByLoop2(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if(right <= left) {
                continue;
            }
            int index = patition(array,left,right);
            stack.push(index + 1);
            stack.push(right);
            stack.push(left);
            stack.push(index - 1);
        }
    }
    public static void mergeSort(int[] array) {
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array,left,mid);
        mergeSortHelper(array,mid,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outputsize = 0;
        while (cur1 < mid && cur2 < right) {
            if(array[cur1] <= array[cur2]) {
                output[outputsize] = array[cur1];
                outputsize++;
                cur1++;
            }else {
                output[outputsize] = array[cur2];
                outputsize++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            output[outputsize] = array[cur1];
            cur1++;
            outputsize++;
        }
        while (cur2 < right) {
            output[outputsize] = array[cur2];
            cur2++;
            outputsize++;
        }
        for(int i = 0;i < right - left;i++) {
            array[left + i] = output[i];
        }
    }

    private static int patition2(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[left];
        while (i < j) {
            while (i < j && array[j] <= base) {
                j--;
            }
            while (i < j && array[i] >= base) {
                i++;
            }
            swap(array,i,j);
        }
        swap(array,i,left);
        return i;
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

    private static void shiftDown(int[] array, int heapSize, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapSize) {
            if(child + 1 < heapSize && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                swap(array,parent,child);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void creatHeap(int[] array) {
        for(int i = (array.length - 1 - 1) / 2;i >= 0;i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void swap(int[] array, int cur, int bound) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        //quickSort2(array);
        //quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
