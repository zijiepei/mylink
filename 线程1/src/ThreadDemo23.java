public class ThreadDemo23 {
    static class SingleDog {
        private SingleDog() {

        }
        private volatile static SingleDog singleDog = null;
        public static SingleDog getSingleDog() {
            if(singleDog == null) {
                synchronized (SingleDog.class) {
                    if(singleDog == null) {
                        singleDog = new SingleDog();
                    }
                }
            }
            return singleDog;
        }
    }
}
