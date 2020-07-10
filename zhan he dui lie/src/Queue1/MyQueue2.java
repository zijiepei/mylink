package Queue1;

public class MyQueue2 {
    private int[] array = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public boolean offer(int val) {
        if(size == array.length) {
            return false;
        }
        array[tail] = val;
        tail++;
        if(tail >= array.length) {
            tail = 0;
        }
        size++;
        return true;
    }
    public Integer pop() {
        if(size == 0) {
            return null;
        }
        int cur = array[head];
        head++;
        if(head >= array.length) {
            head = 0;
        }
        size--;
        return cur;
    }
    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[head];
    }
}
