import java.io.*;

public class IOdemo4 {
    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("g:/test2_dir/1/yasuo.jpg"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("g:/test2_dir/1/yasuo2.jpg"))){
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
