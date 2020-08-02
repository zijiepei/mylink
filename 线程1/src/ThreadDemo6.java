public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("cxk") {
            @Override
            public void run() {
                for(int i = 0;i < 10;i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("要退出了");
            }
        };
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        System.out.println(t.getId());
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());
        t.start();
        while (t.isAlive()) {
            System.out.println("cxk正在运行");
            System.out.println(t.getState());
            System.out.println(t.isInterrupted());
            Thread.sleep(300);
        }
    }
}
