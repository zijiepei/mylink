public class ThreadDemo24 {
    static class BlockingQueue {
        private int[] array = new int[1000];
        private volatile int head = 0;
        private volatile int tail = 0;
        private volatile int size = 0;

        public void put(int val) throws InterruptedException {
            synchronized (this) {
                while (size == array.length) {
                    wait();
                }
                array[tail] = val;
                tail++;
                if(tail == array.length) {
                    tail = 0;
                }
                size++;
                notifyAll();
            }
        }
        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                while (size == 0) {
                    this.wait();
                }
                ret = array[head];
                head++;
                if(head == array.length) {
                    head = 0;
                }
                size--;
                notifyAll();
            }
            return ret;
        }

        public static void main(String[] args) {
            BlockingQueue blockingQueue = new BlockingQueue();
            Thread producer = new Thread() {
                @Override
                public void run() {
                    for(int i = 0;i < 10000;i++) {
                        try {
                            blockingQueue.put(i);
                            System.out.println("生产元素" + i);
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            producer.start();
            Thread consumer = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            int ret = blockingQueue.take();
                            System.out.println("消费元素" + ret);
                            //Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            consumer.start();
        }
    }
}
