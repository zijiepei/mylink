package IO;

import java.io.*;

public class Demo3 {
    public static void main(String[] args) {
        //copyFile();
        copyFile2();
    }

    private static void copyFile2() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("g:/java/tu pian/text.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("g:/java/tu pian/1/text2.txt"))){
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                bufferedWriter.write(string + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() {
        try (FileReader fileReader = new FileReader("g:/java/tu pian/text.txt");
             FileWriter fileWriter = new FileWriter("g:/java/tu pian/1/text1.txt")){
             int len = -1;
             char[] buffer = new char[1024];
             while ((len = fileReader.read(buffer)) != -1) {
                 fileWriter.write(buffer,0,len);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
