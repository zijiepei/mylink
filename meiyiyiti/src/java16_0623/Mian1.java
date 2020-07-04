package java16_0623;

import java.util.HashMap;
import java.util.Map;

public class Mian1 {
    public int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            Integer value = map.get(gifts[i]);
            if(value == null) {
                map.put(gifts[i],1);
            }else {
                map.put(gifts[i],value + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
