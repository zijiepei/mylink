package Array;

import java.util.Arrays;
import java.util.Stack;

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
        //quickSort2(array);
        //quickSort3(array);
        //quickSortByloop2(array);
        //heapSort2(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    /*public static void mergeSort2(int[] array) {
        mergeSortHelper2(array,0,array.length);
    }

    private static void mergeSortHelper2(int[] array, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper2(array,left,mid);
        mergeSortHelper2(array,mid,right);
        merge2(array,left,mid,right);
    }

    private static void merge2(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outputsize = 0;
        while (cur1 < mid && cur2 < right) {
            if(array[cur1] <= array[cur2]) {
                output[outputsize] = array[cur1];
                cur1++;
                outputsize++;
            }else {
                output[outputsize] = array[cur2];
                cur2++;
                outputsize++;
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
    public static void mergeSort3(int[] array) {
        mergeSortHelper3(array,0,array.length);
    }

    private static void mergeSortHelper3(int[] array, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper3(array,left,mid);
        mergeSortHelper3(array,mid,right);
        merge3(array,left,mid,right);
    }

    private static void merge3(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outputsize = 0;
        while (cur1 < mid && cur2 < right) {
            if(array[cur1] <= array[cur2]) {
                output[outputsize] = array[cur1];
                cur1++;
                outputsize++;
            }else {
                output[outputsize] = array[cur2];
                cur2++;
                outputsize++;
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
    public static void quickSort2(int[] array) {
        quickSortHelp2(array,0,array.length - 1);
    }

    private static void quickSortHelp2(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = patition2(array,left,right);
        quickSortHelp2(array,left,index - 1);
        quickSortHelp2(array,index + 1,right);
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
        swap(array,j,left);
        return i;
    }
    public static void quickSort3(int[] array) {
        quickSortHelp3(array,0,array.length - 1);
    }

    private static void quickSortHelp3(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = patition3(array,left,right);
        quickSortHelp3(array,left,index - 1);
        quickSortHelp3(array,index + 1,right);
    }

    private static int patition3(int[] array, int left, int right) {
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
    public static void quickSortbyLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right) {
                continue;
            }
            int index = patition(array,left,right);
            stack.push(index - 1);
            stack.push(left);
            stack.push(right);
            stack.push(index + 1);
        }
    }
    public static void quickSortByloop2(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length- 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right) {
                continue;
            }
            int index = patition(array,left,right);
            stack.push(index - 1);
            stack.push(left);
            stack.push(right);
            stack.push(index + 1);
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
                cur1++;
                outputsize++;
            }else {
                output[outputsize] = array[cur2];
                cur2++;
                outputsize++;
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
    }*/
    public static void insertSort1(int[] array) {
        for(int bound = 1;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for(cur = bound - 1;cur >=0;cur--) {
                if(array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }
    public static void insertSort2(int[] array) {
        for(int bound = 1;bound < array.length;bound++) {
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
    public static void slectSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = bound;cur < array.length;bound++) {
                if(array[cur] < array[bound]) {
                    swap(array,bound,cur);
                }
            }
        }
    }
    private static void swap(int[] array, int bound, int cur) {
        int tmp = array[bound];
        array[bound] = array[cur];
        array[cur] = tmp;
    }
    public static void heapSort1(int[] array) {
        creatHeap1(array);
        int heapsize = array.length;
        for(int i = 0;i < array.length;i++) {/////////////此处也表示计数
            swap(array,0,heapsize - 1);
            heapsize--;
            shiftDown1(array,heapsize,0);
        }
    }

    private static void creatHeap1(int[] array) {
        for(int i = (array.length - 1 - 1) / 2;i >= 0;i--) {
            shiftDown1(array,array.length,i);
        }
    }

    private static void shiftDown1(int[] array, int length, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < length) {
            if(child + 1 < length && array[child + 1] > array[child]) {
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
    public static void heapSort2(int[] array) {
        creatHeap2(array);
        int heapsize = array.length;
        for(int i = 0;i < array.length;i++) {
            swap(array,0,heapsize - 1);
            heapsize--;
            shiftDown2(array,heapsize,0);
        }
    }

    private static void creatHeap2(int[] array) {
        for(int i = (array.length - 1 -1) / 2;i >= 0;i--) {
            shiftDown2(array,array.length,i);
        }
    }

    private static void shiftDown2(int[] array, int length, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < length) {
            if(child + 1 < length && array[child + 1] > array[child]) {
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
    public static void bubbleSort(int[] array) {
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = 0;cur < array.length - 1 - bound;cur++) {
                if(array[cur + 1] < array[cur]) {
                    swap(array,cur + 1,cur);
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
}
