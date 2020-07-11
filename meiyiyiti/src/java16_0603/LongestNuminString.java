package java16_0603;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestNuminString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();////////////////////此处必须按行处理,因为可能中间会有用空格断开的字符串
        int max = 0;//用于记录最长连续数字部分的长度
        int count = 0;//用于每段连续数字的计数
        int end = 0;/////////end始终指向当前最长连续数字的末端
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                count++;
                if(max < count) {
                    max = count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        System.out.println(str.substring(end - max + 1,end + 1));///////此处为一个左闭右开区间[  )
    }
}

