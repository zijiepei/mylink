package java0706;

import java.util.Arrays;

public class Demo12 {
    public static void shiftDown(int[] array,int size,int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            if(array[child] < array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    private static void shiftUp(int[] array,int size,int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(array[child] < array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private static void swap(int[] array, int child, int parent) {
        int tmp = array[child];
        array[child] = array[parent];
        array[parent] = tmp;
    }
    public static void creatHeap1(int[] array,int size) {
        for(int i = 1;i < array.length;i++) {
            shiftUp(array,array.length,i);
        }
    }
    public static void creatHeap2(int[] array,int size) {
        for(int i = (size - 1 - 1) / 2;i >= 0;i--) {
            shiftDown(array,array.length,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        //creatHeap1(array,array.length);
        creatHeap2(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
