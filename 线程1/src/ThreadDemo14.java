public class ThreadDemo14 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for(int i = 0;i < 1000_0000;i++) {

                }
            }
        };
        System.out.println("线程启动前" + t1.getState());
        t1.start();
        while (t1.isAlive()) {
            System.out.println("线程运行中" + t1.getState());
        }
        System.out.println("线程结束后" + t1.getState());
    }
}
