package package2;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDemo {
    //内部类
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //层序遍历(借助队列)
    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return ;
        }
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            System.out.print(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }
    //判断一棵树是不是完全二叉树
    //1.对二叉树进行层序遍历
    //2.遍历过程中第一阶段:每个节点一定都有两个子树
    //临界情况:遇到一个特殊的节点，这个节点可能只有左子树，也可能没有子树
    //(如果只是有右子树，没有左子树，说明一定不是完全二叉树)
    //第二阶段:接下来的每个节点必须都没有子树，如果要是有子树，说明不是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return true;
        }
        if(root!=null){
            queue.offer(root);
        }
        //如果这个标记为true,接下来的节点就不能有子树
        boolean needNoChild=false;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!needNoChild) {//为false,第一阶段
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    queue.offer(cur.left);
                    needNoChild = true;//临界情况
                } else {
                    needNoChild = true;//临界情况
                }
            } else {//为true,第二阶段
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
            return true;
    }
    public boolean isCompleteTree1(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return true;
        }
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        //遍历队列中的元素,看是否都为空
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null){
                return false;
            }
        }
        return true;
    }
}
