package package2;

import java.util.ArrayList;
import java.util.List;

public class TestDemo2 {
    public static void main(String[] args) {
        List<Character> list=searchNotRepeateChar("welcome to bit","come");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
        System.out.println();
    }
    //输入str1="welcome to bit"，str2="come"，输出"wl t bit"
    public static List<Character> searchNotRepeateChar(String str1,String str2){
        List<Character> list=new ArrayList<>();
        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            if(!str2.contains(ch+"")){//contains(字符串)
                list.add(ch);
            }
        }
        return list;
    }
}
