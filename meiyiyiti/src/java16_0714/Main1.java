package java16_0714;

public class Main1 {
    public int getLCA(int a, int b) {
            while (a != b) {
                if(a > b) {
                    a /= 2;
                }else {
                    b /= 2;
                }
            }
            return a;
        }
}
