package JZ9;

public class Main1 {
    public int JumpFloorII(int target) {
      if(target <= 0) {
          return -1;
      }
      if(target == 1) {
          return 1;
      }
      return 2 * JumpFloorII(target - 1);
    }
}
