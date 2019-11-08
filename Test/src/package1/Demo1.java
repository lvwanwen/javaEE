package package1;

public class Demo1 {
    public static void main(String[] args) {
        String s="abcdef";
        String ret=reverse(s);
        System.out.println(ret);
    }
    public static String reverse(String str){
        char[] data=str.toCharArray();
        char tmp;
        int left=0;
        int right=data.length-1;
        while(left<right){
            tmp=data[left];
            data[left]=data[right];
            data[right]=tmp;
            left++;
            right--;
        }
        return String.copyValueOf(data);
    }
}
