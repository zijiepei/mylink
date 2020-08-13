import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOdemo2 {
    public static void main(String[] args) throws IOException {
        copyFile("g:/test2_dir/1/yasuo.jpg","g:/test2_dir/1/2/yasuo2.jpg");
    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //先打开文件,才能读和写
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            //读取srcPath对应的文件内容
            byte[] buffer = new byte[1024];
            //单次读取的内容是存在上限的,想要把整个文件读完,需要循环来读
            int len = -1;
            //如果读到的len是-1,说明读取结束,循环就结束了
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
