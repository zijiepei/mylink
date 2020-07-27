package MapSet;

import java.util.HashSet;
import java.util.Set;

public class Main3 {
    public static int judgeJewel(String J,String S) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < J.length();i++) {
            char c = J.charAt(i);
            set.add(c);
        }
        int count = 0;
        for(char a : S.toCharArray()) {
            if(set.contains(a)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "Asd";
        String S = "AASSddDD";
        System.out.println(judgeJewel(J, S));
    }
}
