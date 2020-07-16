package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {
    /*public static void main(String[] args) throws IOException {
        copyFile("g:/java/tu pian/yasuo.jpg","g:/java/tu pian/1/yassuo.jpg");
    }

    private static void copyFile(String s, String s1) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream(s);
            fileOutputStream = new FileOutputStream(s1);
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileInputStream != null) {
                    fileInputStream.close();
                }
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/////////////////////////////////////////////
    public static void main(String[] args) throws IOException {
       copyFile();
    }

    private static void copyFile() throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream("g:/java/tu pian/yasuo.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("g:/java/tu pian/1/yasuo2.jpg")){
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        }
    }
}
