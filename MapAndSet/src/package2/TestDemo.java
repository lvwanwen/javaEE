package package2;

import java.util.Objects;

//Map<K->学号,V->姓名>
class Person{
    String id;//学号

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
class HashBuck1<K,V>{
    static class Node<K,V>{
        K key;
        V val;
        Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    public Node<K,V>[] array;
    public int usedSize = 0;

    public HashBuck1() {
        this.array = (Node<K,V>[])new Node[8];
    }
    //插入
    public void push(K key,V val){
        int hash = key.hashCode();//调用hashCode方法
        int index = hash%array.length;
        for(Node<K,V>cur = array[index];cur!= null;
            cur = cur.next) {
            //引用类型不能用==，要用equals方法并且要重写equals方法
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }
        }
        //头插
        Node<K,V> node = new Node<>(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
    }
    //查找
    public V get(K key){
        int hash = key.hashCode();
        int index = hash%array.length;
        for(Node<K,V>cur = array[index];cur!= null;
            cur = cur.next) {
            if(cur.key.equals(key)) {
                return cur.val;
            }
        }
        return null;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person person1 = new Person("130601");
        Person person2 = new Person("130601");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        HashBuck1<Person,String> hashBuck1 =
                new HashBuck1<>();
        hashBuck1.push(person1,"l");
        String ret = hashBuck1.get(person2);
        System.out.println(ret);
    }
}
