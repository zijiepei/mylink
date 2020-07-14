package java16_0714;

public class Main2 {
    public static String replaceSpace(String iniString, int length) {
        return iniString.replace(" ","%20");
    }

    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(replaceSpace(s, 7));
    }
}
