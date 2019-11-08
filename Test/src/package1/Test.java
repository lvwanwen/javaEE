package package1;

public class Test {
    public static void main(String[] args) {
        int [][]arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        int[] tmp=findVal(arr,4,4,16);
        System.out.println(tmp[0]+" "+tmp[1]);
    }
    //二维数组查找某个数
    public static int[] findVal(int[][] array,int row,int col,int num){
        int i=0;
        int j=col-1;
        int[] tmp=new int[2];
        while(i<row&&j>=0){
            if(array[i][j]>num){
               j--;
            }
            if (array[i][j]<num) {
                i++;
            }else{
                tmp[0]=i;
                tmp[1]=j;
                return tmp;
            }
        }
        return tmp;
    }
}
