package package1;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        //put时，当key重复，后面的key覆盖前面的key
        //Map在进行put的时候根据key来生成对应的哈希函数，按照这个顺序来存放打印
        map.put(12, "hello");
        map.put(12, "Hello");
        map.put(29, "Java");
        map.put(20, "Java");
        map.put(35, "bit");
        System.out.println(map);
        //get方法key不存在时返回null
        System.out.println(map.get(13));
        //getOrDefault方法key存在返回value,key不存在返回默认值
        String str = map.getOrDefault(39, "world");
        System.out.println(str);
        map.remove(12);
        System.out.println(map);
        boolean a = map.containsKey(29);
        System.out.println(a);
        boolean b = map.containsValue("Java");
        System.out.println(b);
        //将所有的key转变为一个set不重复集合
        Set<Integer> set = map.keySet();
        System.out.println(set);
        //将所有的value转变成一个collection可重复集合
        Collection<String> collection =map.values();
        System.out.println(collection);
        //遍历map
        //Entry是一个静态内部类
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
