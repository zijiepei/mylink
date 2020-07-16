package IO;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("g:/java/tu pian/yasuo.jpg"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("g:/java/tu pian/1/yasuo3.jpg"))) {
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
