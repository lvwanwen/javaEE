package package2;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class TestSort {
    //直接插入排序
    public static  void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int tmp=array[i];
            int j=i-1;
            for(;j>=0;j--){
                if(array[j]>tmp){//若将此处的>改为>=,则会不稳定
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    //希尔排序
    public static void shell(int[] array,int gap){
        for(int i=gap;i<array.length;i++){
            int tmp=array[i];
            int j=i-gap;
            for(;j>=0;j=j-gap){
                if(array[j]>tmp){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    public static void shellSort(int[] array){
        int[] drr={5,3,1};
        for(int i=0;i<drr.length;i++){
            shell(array,drr[i]);
        }
    }
    //直接选择排序
    public static void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
    //堆排序
    public static void heapSort(int[] array){
        for(int i=(array.length-1-1)/2;i>=0;i--){
            adjustDown(array,i,array.length);//把数组建成大根堆
        }
        //将大根堆排序成升序
        int end=array.length-1;
        while(end>0){
            int tmp=array[0];
            array[0]=array[end];
            array[end]=tmp;
            adjustDown(array,0,end);
            end--;
        }
    }
    public static void adjustDown(int[] array,int root,int len){
        //root为开始位置,len为结束位置
        int parent=root;
        int child=2*parent+1;
        while(child<len){
            if(child+1<len&& array[child]< array[child+1]){
                child=child+1;
            }
            if(array[child]>array[parent]){
                int tmp=array[child];
                array[child]=array[parent];
                array[parent]=tmp;
                parent=child;
                child=2*parent+1;
            }else{
                break;
            }
        }
    }
    //冒泡排序
    public static  void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){//i为趟数
            //在数据有序的情况下进行优化，可以定义一个标志
            boolean flg = false;//看一下到底有没有进行交换
            //j为下标
            for(int j=0;j<array.length-1-i;j++){
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;//要是发生了交换,置为true
                }
            }
            if(!flg) {
                break;//要是没有发生交换,flg为false,!flg为true
            }
        }
    }
    //基准值,挖坑法(一趟)
    public static int partition(int[] array,int low,int high){
        int tmp=array[low];//挖坑
        while(low<high){
            while(low<high&&array[high]>=tmp){
                high--;
            }
            if(low>=high){//此时array[high]>=tmp,但是low和high相遇了
                break;
            }else{//此时low<high,但是array[high]<tmp
                array[low]=array[high];//埋坑
            }
            while(low<high&&array[low]<=tmp){
                low++;
            }
            if(low>=high){
                break;
            }else{
                array[high]=array[low];
            }
        }
        array[low]=tmp;
        return low;//此时low=high,return low或者return high都可以
    }
    //基准值的选择(三数取中)
    public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void threeNumMid(int[] array,int low,int high){
        //array[mid] <= array[low] <= array[high]
        int mid = (low+high)/2;
        if(array[mid] > array[low]){
            swap(array,low,mid);
        }
        if(array[mid] > array[high]){
            swap(array,high,mid);
        }
        if(array[low] > array[high]){
            swap(array,low,high);
        }
    }
    //直接插入排序1
    public static void insertSort1(int[] array,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= low ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    //快速排序(递归)
    public static void quick(int[] array,int low,int high){
        //更优化:当某个区间小，且越来越有序时,用直接插入排序更快
//        if(high-low+1 <= 100) {//low与high之间有100个数据
//            insertSort1(array,low,high);
//            return;
//        }
        //优化:待排序序列可能在某一趟比较之后已经成有序的了,这时就不用排了
        //threeNumMid(array,low,high);
        int par = partition(array,low,high);
//        System.out.println("low:"+low);
//        System.out.println("high:"+high);
        //par为low和high相遇的地方,也就是基准值最后所放位置的下标
        if(par > low+1) {//当par前面有两个或两个以上的数据时,递归快速排序前面的数据
            quick(array,low,par-1);
        }
        if(par < high-1) {//当par后面有两个或两个以上的数据时,递归快速排序后面的数据
            quick(array,par+1,high);
        }
    }
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
    //快速排序(非递归)
    public static void quickSort1(int[] array){
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length-1;
        int par = partition(array,low,high);
        if(par > low+1) {
            stack.push(low);
            stack.push(par-1);
        }
        if(par < high-1) {
            stack.push(par+1);
            stack.push(high);
        }
        while (!stack.empty()) {
            //1、取出数对
            high = stack.pop();
            low = stack.pop();
            //2.par
            par = partition(array,low,high);
            if(par > low+1) {
                stack.push(low);
                stack.push(par-1);
            }
            if(par < high-1) {
                stack.push(par+1);
                stack.push(high);
            }
        }
    }
    //合并(一次)
    public static void merge(int[] array,int low,int mid,int high){
        int s1 = low;
        int s2 = mid+1;
        int len = high-low+1;
        int[] tmp = new int[len];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {//此处把<=变为<,就会不稳定
                tmp[i++] = array[s1++];
            }else {
                tmp[i++] = array[s2++];
            }
        }
        //s1++或者s2++,发现这两个其中一个已超过归并段的长度,而另外一个归并段中还有
        //一些数据,将这些数据直接放到tmp数组中
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = array[s2++];
        }
        //两个归并段归并结束,但是他们此时放在tmp数组中，得把他们放到原数组中去
        for (int j = 0; j < tmp.length; j++) {
            //因为下面要递归,low和high是不断变化的,所以要low+j
            array[low+j] = tmp[j];
        }
    }
    //归并排序(递归)
    public static void mergeSort(int[] array,int low,int high) {
        if(low == high) {//只有一个元素了，已分解完
            return;
        }
        int mid = (low+high)/2;
        mergeSort(array,low,mid);//递归左
        mergeSort(array,mid+1,high);//递归右
        merge(array,low,mid,high);//合并
    }
    //归并排序(非递归)
    public static void merge1(int[] array,int gap) {
        int[] tmp = new int[array.length];
        int i = 0;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        //e2有可能会越界，要进行判断
        int e2 = s2+gap-1 >=
                array.length ? array.length-1 : s2+gap-1;
        //当有两个归并段的时候
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    tmp[i++] = array[s1++];
                }else {
                    tmp[i++] = array[s2++];
                }
            }
            //s1++或者s2++,发现这两个其中一个已超过归并段的长度,而另外一个归并段中还有
            //一些数据,将这些数据直接放到tmp数组中
            while (s1 <= e1) {
                tmp[i++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[i++] = array[s2++];
            }
            //重新确定s1  e1  s2  e2 的位置,进行后面的归并
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 >=
                    array.length ? array.length-1 : s2+gap-1;
        }
        //没有两个归并段的时候,判断s1是否有数据,这里不能是s1<=e1,因为e1有可能也会越界
        while (s1 <= array.length-1) {
            tmp[i++] = array[s1++];
        }
        //拷贝tmp到array
        for (int j = 0; j < tmp.length; j++) {
            array[j] = tmp[j];
        }
    }
    public static void mergeSort1(int[] array) {
        for (int gap = 1; gap < array.length; gap*=2) {
            merge1(array,gap);
        }
    }
    //测试代码
    public static void main1(String[] args) {
        int[] array={13,8,2,7,10};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] =random.nextInt(100000);
        }//数组中的数据都是随机的,0到100000之间
        long time1 = System.currentTimeMillis();
        quickSort(array);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);//记录快速排序的时间的,单位为ms
        System.out.println(Arrays.toString(array));
    }
}
