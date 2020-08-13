import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOdemo3 {
        public static void main(String[] args) throws IOException {
            copyFile();
        }
    private static void copyFile() {
        try (FileInputStream fileInputStream = new FileInputStream("g:/test_dir/1/yasuo.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("g:/test_dir/1/2/yasuo2.jpg")){
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
