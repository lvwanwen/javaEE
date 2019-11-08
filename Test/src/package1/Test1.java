package package1;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(function(3));
    }
    //每数到3的出局
    public static int function(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        int count = 0;
        while (n > 1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 1) {
                    count++;
                    if (count == 3) {
                        array[i] = 0;
                        count = 0;
                        n--;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==1){
                return i;
            }
        }
        return -1;
    }
}
