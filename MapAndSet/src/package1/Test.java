package package1;

import java.util.*;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
public class Test {
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
    //找出那个只出现了一次的元素
    public void main1(String[] args) {
        //用异或做
        int[] array = {1, 2, 3, 2, 1};
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp = tmp ^ array[i];
        }
        System.out.println(tmp);
    }

    public int singleNumber(int[] nums) {
        //用set做,把数组中的元素添加进set,当发现set中已经有这个元素时，移除此元素
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        //还的返回
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        //没有返回-1
        return -1;
    }

    //给定一个链表,每个节点包含一个额外增加的随机指针,
    //该指针可以指向链表中的任何节点或空节点,要求返回这个链表的深拷贝
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //第一个Node是老的节点，第二个Node是新的节点
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        //先将next和random设为空的全部复制过来
        while (cur != null) {
            Node node = new Node(cur.val, null, null);
            map.put(cur, node);
            cur = cur.next;
        }
        //再从第一个节点开始复制next和random
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //输入两个字符串J和S,J中的字母不重复,J和S中的所有字符都是字母.字母区分大小写
    //输出S中与J相同字符的个数,如输入J = "aA", S = "aAAbbbb",输出3
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        int count = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }

    //输入在2行中分别给出应该输入的文字、以及实际被输入的文字.
    //每段文字由字母A-Z（包括大、小写）、数字0-9、以及下划线“_”（代表空格）组成。
    //按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次
    //例如输入:7_This_is_a_test  _hs_s_a_es,输出:7TI
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        //因为sc.next()不能输入空格,所以用sc.nextLine()
        String str1 = sc.nextLine();//期望的
        String str2 = sc.nextLine();//实际的
        Set<Character> set = new HashSet<>();
        //字符串中的字母都转为大写，并且变为字符数组
        for (char ch : str2.toUpperCase().toCharArray()) {
            set.add(ch);
        }
        Set<Character> setBroken = new HashSet<>();
        for (char ch : str1.toUpperCase().toCharArray()) {
            //要求每个坏键只输出一次,如果没有!setBroken.contains(ch)条件,结果为7TIITT
            if (!set.contains(ch) && !setBroken.contains(ch)) {
                setBroken.add(ch);
                System.out.print(ch);
            }
        }
    }
    //用PriorityQueue求TopK问题
    public static void topK(int[] array,int k){
        //PriorityQueue底部是小堆
        PriorityQueue<Integer> priQueue=
                new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;//小堆
                //return o2-o1;//大堆
            }
        });
        for (int i = 0; i < array.length; i++){
            if(priQueue.size() < k) {
                priQueue.add(array[i]);//会自动调整为小堆
            }else{
                Integer top = priQueue.peek();//拿到之前已调整成小堆的队首元素
                if(top != null && top <array[i]){
                    priQueue.poll();//队首元素出队列
                    priQueue.add(array[i]);//替换队首元素，重新自动调整为小堆
                }
            }
        }
        System.out.println(priQueue);
    }

    public static void main(String[] args) {
        int[] array = {12,5,7,9,10,13};
        topK(array,3);
    }
}

