package MapSet;
import java.util.Arrays;
public class Main1 {
    /*public int[] singleNumber(int[] nums) {
        int ret = 0;
        for(int x : nums) {
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
        for(int x : nums) {
            if((x & (bit << i)) != 0) {
                a ^= x;
            }else {
                b ^= x;
            }
        }
        int[] array = {a,b};
        return array;
    }*/
    public static int[] singleNumber(int[] nums) {
        int ret = 0;
        for(int x : nums) {
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
        for(int x : nums) {
            if((x & (bit << i)) != 0) {
                a ^= x;
            }else {
                b ^= x;
            }
        }
        int[] array = {a,b};
        return array;
    }
    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4,4,4};
        System.out.println(Arrays.toString(singleNumber(array)));
    }
}
