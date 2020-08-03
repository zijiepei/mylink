package Heap;

public class YouXianQueue {
    int[] array = new int[100];
    int heapSize = 0;
    public void offer(int x) {
        array[heapSize] = x;
        heapSize++;
        shiftUp(array,heapSize,heapSize - 1);
    }

    public Integer poll() {
        if(heapSize <= 0) {
            return null;
        }
        Integer top = array[0];
        array[0] = array[heapSize - 1];
        heapSize--;
        shiftDown(array,heapSize,0);
        return top;
    }

    public Integer peek() {
        if(heapSize <= 0) {
            return null;
        }
        return array[0];
    }

    public boolean empty() {
        return heapSize == 0;
    }
    private void shiftDown(int[] array, int heapSize, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapSize) {
            if(child + 1 < heapSize && array[child + 1] > array[parent]) {
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

    private void shiftUp(int[] array, int heapSize, int index) {
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

    private void swap(int[] array, int parent, int child) {
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

    public static void main(String[] args) {
        YouXianQueue queue = new YouXianQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.empty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
