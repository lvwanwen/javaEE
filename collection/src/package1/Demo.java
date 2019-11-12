package package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王二");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] array=list.toArray();
        System.out.println(Arrays.toString(array));
        list.remove("曹操");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] brray=list.toArray();
        System.out.println(Arrays.toString(brray));
        list.remove("张三");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] crray=list.toArray();
        System.out.println(Arrays.toString(crray));
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] drray=list.toArray();
        System.out.println(Arrays.toString(drray));
    }
}
