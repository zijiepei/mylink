import java.io.File;
import java.io.IOException;

public class IOdemo1 {

    public static void main(String[] args) throws IOException {
        File file = new File("g:/test2_dir/1");
        //System.out.println(file.exists());
        //System.out.println(file.isDirectory());
        file.mkdirs();
        //System.out.println(file.exists());
        lsitAllFiles(file);
    }
    private static void lsitAllFiles(File f) {
        if(f.isDirectory()) {
            File[] files = f.listFiles();
            for(File file : files) {
                lsitAllFiles(file);
            }
        }else {
            System.out.println(f);
        }
    }
}
