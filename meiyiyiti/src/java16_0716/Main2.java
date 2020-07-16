package java16_0716;

public class Main2 {
    public static String reverse(String sentence) {
        String[] strings = sentence.split(" ");
        String[] strings2 = new String[strings.length];
        int i = strings.length - 1;
        int j = 0;
        String ret = "";
        for(;i >= 0;i--) {
            for(;j <= strings.length - 1;j++) {
                strings2[j] = strings[i];
                break;
            }
        }
        ret += strings2[0];
        for(int m = 1;m <= strings2.length - 1;m++) {
            ret = ret + " ";
            ret = ret + strings2[m];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(reverse("i am a student"));
    }
}
