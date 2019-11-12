package package1;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("作者", "鲁迅");
        map.put("标题", "狂人日记");
        map.put("发表时间", "1918年");
        System.out.println(map.get("作者"));
        System.out.println(map.get("鲁迅"));
        System.out.println(map.getOrDefault("作者","鲁迅"));
        System.out.println(map.getOrDefault("作者","我"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("鲁迅"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
