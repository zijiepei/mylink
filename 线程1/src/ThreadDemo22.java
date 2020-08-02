public class ThreadDemo22 {
    static class SingleDog {
        private SingleDog() {

        }
        private static SingleDog singleDog = new SingleDog();
        public static SingleDog getSingleDog() {
            return singleDog;
        }
    }

    public static void main(String[] args) {
        SingleDog s1 = SingleDog.getSingleDog();
        SingleDog s2 = SingleDog.getSingleDog();
        System.out.println(s1 == s2);
    }
}
