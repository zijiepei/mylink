package Heap;
public class YouXianQueue {
    public int[] array = new int[100];
    public int size = 0;
    public void offer(int x) {
        array[size] = x;
        size++;
        shiftUp(array,size,size - 1);
    }
    public Integer poll() {
        int top = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array,size,0);
        return top;
    }
    public Integer peek() {
        return array[0];
    }
    public boolean empty() {
        return size == 0;
    }
    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            if(array[child] < array[parent]) {
                swap(array,parent,child);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(array[child] < array[parent]) {
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
        YouXianQueue youXianQueue = new YouXianQueue();
        youXianQueue.offer(9);
        youXianQueue.offer(5);
        youXianQueue.offer(2);
        youXianQueue.offer(7);
        youXianQueue.offer(3);
        youXianQueue.offer(6);
        youXianQueue.offer(8);
        while (!youXianQueue.empty()) {
            System.out.print(youXianQueue.poll() + " ");
        }
    }
}
