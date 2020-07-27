package MapSet;

import java.util.*;

public class Main5 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
       for(String s : words) {
           Integer value = map.getOrDefault(s,0);
           map.put(s,value + 1);
       }
       List<String> list = new ArrayList<>(map.keySet());
       Collections.sort(list, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
              int count1 = map.get(o1);
              int count2 = map.get(o2);
              if(count1 == count2) {
                  return o1.compareTo(o2);
              }
              return count2 - count1;
           }
       });
       return list.subList(0,k);
    }
}
