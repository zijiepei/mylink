
public class ThreadDemo1 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我是一个线程");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        while (true) {

        }
    }
}
