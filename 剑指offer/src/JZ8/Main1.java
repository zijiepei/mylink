package JZ8;

public class Main1 {
    public int JumpFloor(int target) {
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        int i = 1;
        int j = 2;
        int k = -1;
        for(int n = 3;n <= target;n++) {
            k = i + j;
            i = j;
            j = k;
        }
        return k;
    }
}
