package package2;

public class HashBuck {
    //静态内部类
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node[] array;
    public int usedSize;

    public HashBuck() {
        this.array = new Node[4];
        this.usedSize = 0;
    }

    //插入
    public void put(int key, int value) {
        int index = key % array.length;//下标
        //根据下标找元素，当第一次cur为空时,此下标为null
        //只有一个cur时，此下标中只有一个元素，cur大于一个时，下标里存的是单链表
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
        }
        //发生哈希冲突时，桶里存单链表，利用头插法插入,桶里已经有null了
        Node node = new Node(key, value);
        node.next = array[index];
        this.usedSize++;
        if (loadFactor() >= 0.75) {
            resize();//当负载因子大于等于0.75时，扩容
        }
    }

    private double loadFactor() {//负载因子
        return this.usedSize * 1.0 / array.length;
    }

    //2倍进行扩容，重新映射
    public void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node curNext;
            for (Node cur = array[i]; cur != null;cur = curNext) {
                curNext = cur.next;
                //重新映射到新的数组当中
                int index = cur.key%newArray.length;
                //头插法
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array=newArray;
    }
    //查找
    public int get(int key){
        int index = key % array.length;
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return  cur.value;
            }
        }
        return -1;
    }
}
