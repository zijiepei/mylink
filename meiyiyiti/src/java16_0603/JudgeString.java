package java16_0603;

public class JudgeString {
    public boolean chkParenthesis(String A, int n) {
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i < n;i++) {
            char c = A.charAt(i);
            if(c == '(') {
                count1++;
            }
            if(c == ')') {
                count2++;
            }
            if(c != '(' && c != ')') {
                return false;
            }
        }
        if(count1 != count2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
