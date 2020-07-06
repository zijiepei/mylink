package Stack;

public class MyStack {//顺序表
        public int[] array = new int[100];
        public int size = 0;
        public void push(int x) {
            array[size] = x;
            size++;
        }
        public Integer pop() {
            if(size <= 0) {
                return null;
            }
            int ret = array[size - 1];
            size--;
            return ret;
        }
        public Integer peek() {
            if(size <= 0) {
                return null;
            }
            return array[size - 1];
        }
        public boolean empty() {
            return size == 0;
        }

        public static void main(String[] args) {
            MyStack stack = new MyStack();
            stack.push(9);
            stack.push(5);
            stack.push(2);
            stack.push(7);
            stack.push(3);
            stack.push(6);
            stack.push(8);
            while (!stack.empty()) {
                Integer cur = stack.pop();
                System.out.print(cur + " ");
            }
        }
}
