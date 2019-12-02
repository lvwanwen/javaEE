package package1;

import java.util.Arrays;

public class Heap {
    //创建elem和usedSize方便入队列,出队列以及扩容
    public int[] elem;
    public int usedSize;

    public Heap() {
        this.elem = new int[20];
        this.usedSize=0;
    }
    //大根堆,向下调整(一次调整)
    public void adjustDown(int root,int len){
        int parent=root;//每次调整的这棵树的根节点下标
        int child=2*parent+1;//若左>右,c为左
        while(child<len){
            if(child+1<len&&elem[child]<elem[child+1]){
                child=child+1;//判断是否有右，若有右并且右>左,c为右
            }
            if(elem[child]>elem[parent]){
                int tmp=elem[child];
                elem[child]=elem[parent];
                elem[parent]=tmp;
                //调整下面的
                parent=child;
                child=2*parent+1;
            }else{
                break;
            }
        }
    }
    //建堆,从倒数第一个非叶子节点的子树开始调整,一直调整到根节点的树,就可以调整成堆
    public void createHeap(int[] array){
        for(int i=0;i<array.length;i++){
            this.elem[i]=array[i];
            this.usedSize++;
        }
        for(int i=(this.usedSize-1-1)/2;i>=0;i--){
            adjustDown(i,this.usedSize);
        }
    }
    //入队列
    public void pushHeap(int val){
        //判断是否已满,若满了则扩容
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.usedSize]=val;//按尾插方式放入数组
        this.usedSize++;
        adjustUp(usedSize-1);
    }
    public boolean isFull(){
        return this.usedSize==this.elem.length;
    }
    //向上调整
    public void adjustUp(int child){
        int parent=(child-1)/2;
        while(child>0){
            if(elem[child]>elem[parent]){
                int tmp=elem[child];
                elem[child]=elem[parent];
                elem[parent]=tmp;
                //调整上面的
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }
    //出队列
    public void popHeap(){
        //判断堆是否为空
        if(isEmpty()){
            return;
        }
        //堆顶元素和最后一个元素进行交换
        int tmp=elem[0];
        elem[0]=elem[this.usedSize-1];
        elem[this.usedSize-1]=tmp;
        this.usedSize--;//删除最后一个元素，也就是先前的堆顶元素
        //向下调整成大堆,只需要调整最大的树即可,别的树已经为大堆了
        adjustDown(0,this.usedSize);
    }
    public boolean isEmpty(){
        return this.usedSize==0;
    }
    //返回堆顶元素
    public int getPop(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[0];
    }
    public void display(){
        for(int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //堆排序
    public void heapSort(){
        int end=this.usedSize-1;
        while(end>0){
            int tmp=elem[0];
            elem[0]=elem[end];
            elem[end]=tmp;
            //此时还不能end--,因为在上面的向下调整程序中不包含end
            //是<end,而不是<=end,所以要向下调整完成后，再end--
            adjustDown(0,end);
            end--;
        }
    }
}
