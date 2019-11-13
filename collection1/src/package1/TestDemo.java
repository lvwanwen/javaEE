package package1;

import java.util.Stack;

public class TestDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(10);
        myQueue.offer(20);
        myQueue.offer(30);
        myQueue.offer(40);
        myQueue.offer(50);
        System.out.println(myQueue.size());//5
        System.out.println(myQueue.poll());//10
        System.out.println(myQueue.peek());//20
        System.out.println(myQueue.size());//4
    }
    public static void main1(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("uuu");
        MyStack<Integer> myStack=new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.size());//4
        System.out.println(myStack.pop());//4
        System.out.println(myStack.peek());//3
        System.out.println(myStack.size());//3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//2
        System.out.println(myStack.pop());//1
        System.out.println(myStack.size());//0
        //System.out.println(myStack.pop());
    }
}
