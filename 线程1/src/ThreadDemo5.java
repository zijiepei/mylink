public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t1 = new Thread("这是一个线程的名字") {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t1.start();
    }
}
