package java16_0627;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] array = {1,2,6,5,4};
        Arrays.sort(array,3,5);
        System.out.println(Arrays.toString(array));
    }
}
