package package1;

public class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;

    public MyCircularQueue() {
        this.elem = new int[10];
        this.front = 0;
        this.rear = 0;
    }
    //是否满了
    public boolean isFull(){
        if((this.rear+1)%this.elem.length==this.front){
            return true;
        }
        return false;
    }
    //入队
    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        this.elem[this.rear]=value;
        this.rear=(this.rear+1)%this.elem.length;
        return true;
    }
    //是否为空
    public boolean isEmpty() {
        if(this.front == this.rear) {
            return true;
        }
        return false;
    }
    //出队
    public boolean deQueue(){
        if(isEmpty()) {
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        return true;
    }
    //得到队头元素
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }
    //得到队尾元素
    public int Rear(){
        if(isEmpty()) {
            return -1;
        }
        int index;
        if(this.rear==0){
            index=this.elem.length-1;
        }else{
            index=this.rear-1;
        }
        return this.elem[index];
    }
}
