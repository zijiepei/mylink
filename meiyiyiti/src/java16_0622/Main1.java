package java16_0622;

public class Main1 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        n = p.length;
        boolean[] ret = new boolean[n];
        for(int i = 0;i < n;i++) {
            String s1 = p[i];
            if(s.contains(s1)) {
                ret[i] = true;
            }else {
                ret[i] = false;
            }
        }
        return ret;
    }
}
