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

    }
}
