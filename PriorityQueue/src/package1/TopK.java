package package1;

//TopK问题
public class TopK {
    //小根堆，向下调整(一次调整)
    private static void adjustDown(int[] array,int root,int len){
        int parent=root;
        int child=2*parent+1;
        while(child<len){
            if(child+1<len&& array[child]>array[child+1]){
                child=child+1;
            }
            if(array[child]<array[parent]){
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
    private static void heapTopk(int[] array,int k,int N){
        int[] data=new int[k];
        if(data==null){
            return;
        }
        for(int i=0;i<k;i++){
            data[i]=array[i];
        }
        //前k个建小堆
        for(int i=(k-1-1)/2;i>=0;i--){
            adjustDown(data,i,k);
        }
        //遍历比较其余元素
        for(int i=0;i<N-k;i++){
            if(data[0]<array[k+i]){
                data[0]=array[k+i];
                adjustDown(data,0,k);
            }
        }
        for(int i=0;i<k;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array={2,7,9,12,3,6,1,5,4,10};
        heapTopk(array,4,array.length);
    }
}
