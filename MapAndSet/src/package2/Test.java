package package2;

public class Test {
    //测试二叉搜索树
    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        int[] array={10,2,8,12,30,15,20};
        for(int i=0;i<array.length;i++){
            bst.insert(array[i]);
        }
        bst.prevOrder(bst.root);
        System.out.println();
        bst.InOrder(bst.root);
        System.out.println();
        //search方法返回的是Node类型,Node是静态内部类
        //如果查找的节点没在二叉搜索树中，会出现空指针异常
        try {
            BinarySearchTree.Node ret=bst.search(10);
            System.out.println(ret.val);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ret为空");
        }
        bst.remove(20);
        bst.InOrder(bst.root);
    }
}
