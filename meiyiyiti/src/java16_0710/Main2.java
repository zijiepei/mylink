package java16_0710;

public class Main2 {
    public int calculateMax(int[] prices) {
        int firstbuy = Integer.MAX_VALUE;
        int afterfirstsell = 0;
        int aftersecondbuy = Integer.MIN_VALUE;
        int aftersecondsell = 0;
        for(int curprice : prices) {
            firstbuy = Math.min(firstbuy,curprice);
            afterfirstsell = Math.max(afterfirstsell,curprice - firstbuy);
            aftersecondbuy = Math.max(aftersecondbuy,afterfirstsell - curprice);
            aftersecondsell = Math.max(aftersecondsell,aftersecondbuy + curprice);
        }
        return aftersecondsell;
    }
}
