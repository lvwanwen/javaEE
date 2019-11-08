package package2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //hasNext()表示如果此扫描仪在其输入中有另一个令牌，则返回true
        while(sc.hasNext()){//可以不断输入
            int n=sc.nextInt();
            String str=sc.next();
            String s=reverseSentence(str,n);
            System.out.println(s);
        }
    }
    //给一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体右移到右半区，
    //右半区整体移动到左边，例如输入3 abcdefg,输出defgabc
    public static String reverse(String str,int start,int end){
        char[] data=str.toCharArray();
        while(start<end){
            char tmp=data[start];
            data[start]=data[end];
            data[end]=tmp;
            start++;
            end--;
        }
        //copyValueOf表示返回char数组参数的字符串表示形式
        return String.copyValueOf(data);
    }
    //思想:abcdefg->cbadefg->cbagfed->defgabc
    public static String reverseSentence(String str,int n){
        if(str==null||str.length()==0||n<0||n>str.length()){
            return null;
        }
        int s1=0;
        int e1=n-1;
        int s2=n;
        int e2=str.length()-1;
        str=reverse(str,s1,e1);
        str=reverse(str,s2,e2);
        str=reverse(str,s1,e2);
        return str;
    }
}
