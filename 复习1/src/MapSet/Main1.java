package MapSet;

public class Main1 {
    public static int[] singleNum(int[] array) {
        int ret = 0;
        for(int x : array) {
            ret ^= x;
        }
        int bit = 1;
        int i = 0;
        for(;i < 32;i++) {
            if((ret & (bit << i)) != 0) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for(int x : array) {
            if((x & (bit << i)) != 0) {
                a ^= x;
            }else {
                b ^= x;
            }
        }
        int[] result = {a,b};
        return result;
    }
    public static int[] singleNum2(int[] array) {
        int ret = 0;
        for(int x : array) {
            ret ^= x;
        }
        int bit = 1;
        int i = 0;
        for(;i < 32;i++) {
            if((ret & (bit << i)) != 0) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for(int x : array) {
            if((x & (bit << i)) != 0) {
                a ^= x;
            }else {
                b ^= x;
            }
        }
        int[] result = {a,b};
        return result;
    }
}
