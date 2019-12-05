package package1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        //add添加元素时，重复元素不会被添加成功,打印结果时无序的
        set.add("hello");
        set.add("Java");
        set.add("hello");
        set.add("world");
        set.add("bit");
        System.out.println(set);
        set.remove("hello");
        System.out.println(set);
        boolean a=set.contains("hello");
        System.out.println(a);
//        set.clear();
//        System.out.println(set);
        //迭代器遍历set
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
