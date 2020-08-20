import java.util.Arrays;
import java.util.Stack;

public class Sort {
    public static void insertSort(int[] array) {////////////////////////////////////////////////////////////////插入排序
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
    public static void shellSort(int[] array) {////////////////////////////////////////////希尔排序
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }
    private static void insertSortGap(int[] array,int gap) {
        for(int bound = gap;bound < array.length;bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for (;cur >= 0;cur = cur - gap) {
                if(array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }
    public static  void slectSort(int[] array) {/////////////////////////////////////选择排序
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = bound;cur < array.length;cur++) {
                if(array[cur] < array[bound]) {
                    swap(array, bound, cur);
                }
            }
        }
    }

    private static void swap(int[] array, int bound, int cur) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
    }
    public static void heapSort(int[] array) {/////////////////////////////////////////堆排序
        creatHeap(array);
        int heapSize = array.length;
        for(int i = 0;i < array.length;i++) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }

    private static void creatHeap(int[] array) {
        for(int i = (array.length - 1 -1) / 2; i >= 0;i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int length, int i) {
        int parent = i;
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
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void bubbleSort(int[] array) {//冒泡排序,这里面的bound代表次数,上面的bound都代表下标值
        for(int bound = 0;bound < array.length;bound++) {
            for(int cur = 0;cur < array.length - 1 - bound;cur++) {
                if(array[cur + 1] < array[cur]) {
                    swap(array,cur,cur + 1);
                }
            }
        }
    }
    public static void quickSort(int[] array) {//////////////////快速排序////////////////////////////////////////////////////
        quickSortHeaper(array,0,array.length - 1);
    }

    private static void quickSortHeaper(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int index = patition(array,left,right);
        quickSortHeaper(array,left,index - 1);
        quickSortHeaper(array,index + 1,right);
    }

    private static int patition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            if (i < j) {
                swap(array,i,j);
            }
        }
        swap(array,i,right);
        return i;
    }
   public static void quickSortByLoop(int[] array) {
       Stack<Integer> stack = new Stack<>();
       stack.push(0);
       stack.push(array.length - 1);
       while (!stack.isEmpty()) {
           int right = stack.pop();
           int left = stack.pop();
           if(left >= right) {
               continue;
           }
           int index = patition(array,left,right);
           stack.push(index + 1);
           stack.push(right);
           stack.push(left);
           stack.push(index - 1);
       }
   }
   public static void mergeSort(int[] array) {/////////////////////////归并排序,区间为[left,right)
       mergeSortHelper(array,0,array.length);
   }

    private static void mergeSortHelper(int[] array,int left,int right) {
        if (right - left <= 1) {
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
            if (array[cur1] <= array[cur2]) {
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
        for (int i = 0;i < right - left;i++) {
            array[left + i] = output[i];///////////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
    //public static void mergeSortbyloop()

    public static void main(String[] args) {
        int[] array1 = {9,5,2,7,3,6,8};
        //insertSort(array1);

        //System.out.println(Arrays.toString(array1));
        //insertSortGap(array1,3);
        //System.out.println(Arrays.toString(array1));
        //slectSort(array1);
        //heapSort(array1);
        //bubbleSort(array1);
        //quickSort(array1);
        //quickSortByLoop(array1);
        mergeSort(array1);
        System.out.println(Arrays.toString(array1));
    }
}
