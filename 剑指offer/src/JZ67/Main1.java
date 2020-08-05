package JZ67;

public class Main1 {
    public int cutRope(int target) {
       if(target == 2) {
           return 2;
       }
       if(target == 3) {
           return 3;
       }
       int[] dp = new int[target + 1];
       //当target大于等于四时,上述所有长度的子绳子不必再分
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int ret = 0;////记录每个绳子长度的最大值,存在数组中,数组下标代表其绳长
        for(int n = 4; n <= target;n++) {
            for(int j = 1;j <= n / 2;j++) {
                ret = Math.max(ret, dp[j] * dp[n - j]);
            }
            dp[n] = ret;
        }
        return dp[target];
    }
}
