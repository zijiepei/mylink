import java.io.*;

public class IOdemo5 {
    public static void main(String[] args) {
        //copyFile();
        copyFile2();
    }

    private static void copyFile() {
        try (FileReader fileReader = new FileReader("g:/test3_dir/1/1.txt");
             FileWriter fileWriter = new FileWriter("g:/test3_dir/1/2/2.txt")){
            int len = -1;
            char[] buffer = new char[1024];
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFile2()  {//字符流带缓冲区的可以按行读取
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("g:/test3_dir/1/1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("g:/test3_dir/1/2/4.txt"))){
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                ////readLine读取每一行的时候,会把最末尾的换行符给去掉
                bufferedWriter.write(line + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
