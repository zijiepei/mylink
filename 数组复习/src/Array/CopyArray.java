package Array;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
//        int[] ret = Arrays.copyOfRange(array,1,3);
//        System.out.println(Arrays.toString(ret));
        int[] ret = array.clone();
        System.out.println(Arrays.toString(ret));
    }
}
