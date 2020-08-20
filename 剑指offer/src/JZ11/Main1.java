package JZ11;

public class Main1 {
    public int NumberOf1(int n) {
        if(n == 0) {
            return 0;
        }
        int bit = 1;
        int i = 0;
        int count = 0;
        for(;i < 31;i++) {
           if((n & (bit << i)) != 0) {
               count++;
           }
        }
        if(n > 0) {
          return count;
        }
        return ++count;
    }
}
