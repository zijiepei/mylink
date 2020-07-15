public class YouXianQueue2 {
    private int[] array = new int[100];
    private int size = 0;
    public void offer(int x) {
        array[size] = x;
        size++;
        shiftUp(array,size,size - 1);
    }

    private void shiftUp(int[] array, int size, int index) {
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
    public Integer poll() {
        if(size == 0) {
            return null;
        }
        Integer cur = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array,size,0);
        return cur;
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
         }
    }
    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[0];
    }
    public boolean empty() {
        return  size == 0;
    }

    public static void main(String[] args) {
        YouXianQueue2 queue = new YouXianQueue2();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.empty()) {
            Integer cur = queue.poll();
            System.out.print(cur + " ");
        }
    }
}
