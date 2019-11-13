package package1;
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class MyQueue {
    public Node head;
    public Node tail;
    public int usedSize;
    //入队
    public void offer(int data){
        Node node=new Node(data);
        //第一次入队
        if(this.head==null){
            this.head=node;
            this.tail=node;
        }else{
           this.tail.next=node;
           this.tail=this.tail.next;
        }
        this.usedSize++;
    }
    //出队
    public int poll(){
        if(this.head==null){
            return -1;
        }
        int oldData=this.head.data;
        this.head=this.head.next;
        this.usedSize--;
        return oldData;
    }
    //得到队列的队头元素 并且不删除
    public int peek(){
        if(this.head==null){
            return -1;
        }
        return this.head.data;
    }
    public int size() {
        return this.usedSize;
    }
}
