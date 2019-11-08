package package1;

import java.util.Scanner;

public class Test2 {
    public static void main4(String[] args) {
        String str = "name=zhangsan&age=18" ;
        String[] result = str.split("&") ;
        //name=zhangsan
        //age=18
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split("=") ;
            System.out.println(temp[0]+" = "+temp[1]);
        }
        //name = zhangsan
        //age = 18
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();//回车
        String str = scanner.next();
        //输完a回车输str,但如果是scanner.nextLine输完a回车就输不了str了
        System.out.println(a);
        System.out.println(str);
    }
    public static void main2(String[] args) {
        String str1 = "abcdef";
        String str2 = new String("abcdef");
        System.out.println(str1 == str2);//false
        String str3= new String("abcdef");
        System.out.println(str2 == str3);//false
        //如果两个字符串常量直接拼接+，那么在编译期间就处理为拼接的结果
        String str4 = "ab"+"cdef";
        System.out.println(str1 == str4);//true
        String str5 = "ab" + new String("cdef");
        System.out.println(str1 == str5);//false
        String str6 = "ab";
        String str7 = "cdef";
        String str8 = str6+str7;//str6,str7为变量
        System.out.println(str1 == str8);//false
        String str9 = str6+"cdef";
        System.out.println(str1 == str9);//false
        String str10 = "hello" + 10;
        String str11 = "hello10";
        System.out.println(str10 == str11);//true
    }
    public static void main1(String[] args) {
        String str1 = "abcdef";
        String str3 = "abcdef";
        System.out.println(str1 == str3);//true
        System.out.println(str1.equals(str3));//true
    }
}
