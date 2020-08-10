package Heap;

public class Heap {
    public static void shiftDown(int[] array,int size,int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {
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

    private static void swap(int[] array, int parent, int child) {
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

    public static void shiftUp(int[] array,int size,int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(array[child] > array[parent]) {
                swap(array,parent,child);
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public static void creatHeap(int[] array) {
        for(int i = (array.length - 1) / 2;i >= 0;i--) {
            shiftDown(array,array.length,i);
        }
    }

    public static void creatHeap2(int[] array) {
        for(int i = 1;i < array.length;i++) {
            shiftUp(array,array.length,i);
        }
    }
}
