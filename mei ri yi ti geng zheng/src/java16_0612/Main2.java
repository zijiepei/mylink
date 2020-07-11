package java16_0612;

public class Main2 {
    public static int ret(int a) {
        return ++a;
    }
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
       for(int i = 0;i < B.length;i++) {
          B[i] = 1;
          for(int j = 0;j < A.length;j++) {
              if(i == j) {
                  continue;
              }
           B[i] *= A[j];
          }
       }
       return B;
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(ret(a));
    }
}
