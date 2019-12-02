package package1;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        //默认为小根堆
        Queue<Integer> queue=new PriorityQueue<>();
        queue.offer(9);
        queue.offer(8);
        queue.offer(2);
        queue.offer(7);
        queue.offer(10);
        System.out.println(queue);
        System.out.println(queue.peek());
        int a=queue.poll();
        System.out.println(a);
        System.out.println(queue);
    }
    public static void main1(String[] args) {
        int[] array={13,8,2,7,10,9,11,15,12,6};
        Heap heap=new Heap();
        heap.createHeap(array);
        heap.display();
        heap.heapSort();
        heap.display();
//        heap.pushHeap(20);
//        heap.display();
//        heap.popHeap();
//        heap.display();
//        int ret=heap.getPop();
//        System.out.println(ret);
    }
}
