package package1;

public class MyStack<E> {
    public E[] elem;
    public int top;

    public MyStack() {
        this.elem = (E[]) new Object[10];
    }

    //栈是否满了
    public boolean isFull() {
        if (this.top == this.elem.length) {
            return true;
        }
        return false;
    }

    //入栈
    public void push(E data) {
        if (isFull()) {
            return;
        }
        this.elem[top] = data;
        top++;
    }

    //是否为空
    public boolean isEmpty() {
        if (this.top == 0) {
            return true;
        }
        return false;
    }

    //出栈->保存出栈的元素
    public E pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        E num = this.elem[top - 1];
        top--;
        return num;
    }

    //得到栈顶元素-》但是不删除该栈顶的元素
    public E peek() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[this.top - 1];
    }
    public int size(){
        return this.top;
    }
}
