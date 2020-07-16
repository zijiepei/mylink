package IO;

import java.io.File;

public class Demo4 {
    public static void listAllFile(File f) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                listAllFile(file);
            }
        }else {
            System.out.println(f);
        }
    }
}
