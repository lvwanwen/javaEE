package package2;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(func(str));
    }
    //实现无亢余地接受两个字符串，然后把它们无亢余的连接起来
    //例如输入abc def,输出abcdef
    public static String func(String str){
        String[] strs=str.split(" ");//[abc,def]
        StringBuffer sb=new StringBuffer();
        for(String s:strs){
            sb.append(s);
        }
        return sb.toString();
    }
}
