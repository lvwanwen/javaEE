package package1;

import java.util.Scanner;

public class BinaryTreeDemo {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    // 二叉树的构建及遍历:输入一串先序遍历字符串,根据此字符串建立一个二叉树
    //再对二叉树进行中序遍历，输出遍历结果,“#”表示的是空格，空格字符代表空树
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //可能有多组输入的情况
        while(sc.hasNext()){
            String str=sc.next(); //一组先序遍历的结果
            TreeNode root=buildTree(str);
            inOrder(root);
            System.out.println();
        }
    }
    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    public static int i=0;//字符串的下标
    //i如果是局部变量，每次递归进去，i都为0，遍历就会有问题
    public static TreeNode buildTree(String str){
        TreeNode root=null;
        if(str.charAt(i)!='#'){
            root=new TreeNode(str.charAt(i));
            i++;
            root.left=buildTree(str);//因为有递归所以不用for循环遍历字符串了
            root.right=buildTree(str);
            //root.left和root.right不用在i++了，因为每次递归root都i++过了
        }else{
            i++;
        }
        return root;
    }
}
