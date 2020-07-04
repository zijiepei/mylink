package java16_0613;

import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        return AB;
    }
    Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
    }
}
