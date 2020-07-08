package java16_0708;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            scanner.nextLine();
            Map<String,Integer> map1 = new HashMap<>();
            Map<String,Integer> map2 = new HashMap<>();
            int count = 0;
            for(int i = 0;i < N;i++) {
                String s = scanner.nextLine();
                String[] string = s.split(" ");
                if(string[0].equals(string[1])) {
                    count++;
                }
                else if(string[0].equals("J")) {
                    if(string[1].equals("C")) {
                        Integer value = map2.getOrDefault("C",0);
                        map2.put("C",value + 1);
                    }else {
                        Integer value = map1.getOrDefault("J", 0);
                        map1.put("J", value + 1);
                    }
                }else if (string[0].equals("C")) {
                    if(string[1].equals("B")) {
                        Integer value = map2.getOrDefault("B",0);
                        map2.put("B",value + 1);
                    }else {
                        Integer value = map1.getOrDefault("C",0);
                        map1.put("C",value + 1);
                    }
                }else if(string[0].equals("B")) {
                    if(string[1].equals("J")) {
                        Integer value = map2.getOrDefault("J",0);
                        map2.put("J",value + 1);
                    }else {
                       Integer value = map1.getOrDefault("B",0);
                        map1.put("B",value + 1);
                    }
                }
            }
            int sum1 = 0,max1 = 0,sum2 = 0,max2 = 0;
            String s1 = "",s2 = "";
            Set set1 = map1.keySet();
            Object[] arr = set1.toArray();
            Arrays.sort(arr);
            Integer value1 = 0;
            for(Map.Entry<String,Integer> entry : map1.entrySet()) {
                 value1 = entry.getValue();
                if(value1 > max1) {
                    max1 = value1;
                }
                s1 = entry.getKey();
                sum1 += value1;
            }
            for(Object key : arr) {
                if(map1.get(key).equals(value1)) {
                    s1 = (String)key;
                    break;
                }
            }
            Set set2 = map2.keySet();
            Object[] arry = set2.toArray();
            Arrays.sort(arry);
            Integer value2 = 0;
            for(Map.Entry<String,Integer> entry : map2.entrySet()) {
                 value2 = entry.getValue();
                if(value2 > max1) {
                    max2 = value2;
                }
                s2 = entry.getKey();
                sum2 += value2;
            }
            for(Object key : arry) {
                if(map2.get(key).equals(value1)) {
                    s2 = (String)key;
                    break;
                }
            }
            System.out.println(sum1+" "+count+" "+sum2);
            System.out.println(sum2+" "+count+" "+sum1);
            System.out.println(s1+" "+s2);
        }
    }
}
