package package2;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//二叉树的前序遍历
public class BinaryTree {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.val);
        List<Integer> left=preorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right=preorderTraversal(root.right);
        list.addAll(right);
        return list;
    }
    //二叉树中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer> left=inorderTraversal(root.left);
        list.addAll(left);
        list.add(root.val);
        List<Integer> right=inorderTraversal(root.right);
        list.addAll(right);
        return list;
    }
    //二叉树后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        List<Integer> left = postorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = postorderTraversal(root.right);
        list.addAll(right);
        list.add(root.val);
        return list;
    }
    // 检查两颗树是否相同(结构相同，并且节点具有相同的值)(两个对象，比较值)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q==null||p==null&&q!=null){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        //都不为空树时，比较一下根节点的值是否相同，如果不相同，就直接返回false
        //递归比较左子树和递归比较右子树看看是不是也相同
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //另一颗树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s!=null&&t==null||s==null&&t!=null){
            return false;
        }
        if(s==null&&t==null){
            return true;
        }
        //s是否包含t->s和t是不是相等+s.left是不是包含t+s.right是不是包含t
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubtree(s.left,t)){
            return true;
        }
        if(isSubtree(s.right,t)){
            return true;
        }
        return false;
    }
    //二叉树最大深度/高度
    public int maxDepth(TreeNode root) {
        //空树
        if(root==null){
            return 0;
        }
        //只有根节点
        if(root.left==null&&root.right==null){
            return 1;
        }
        //root的深度=>1(根节点)+左子树的深度和右子树的深度的最大值
        int left=maxDepth(root.left);//左子树的深度
        int right=maxDepth(root.right);//右子树的深度
        return 1+(left>right?left:right);
    }
    //判断一颗二叉树是否是平衡二叉树
    //平衡二叉树:一个二叉树每个节点的左右两个子树的高度差的绝对值<=1
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        //求一下当前节点左右子树的高度，判断差值是否<=1
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if((left-right>1)||(right-left>1)){
            return false;
        }
        //递归判定左子树和右子树是不是也是平衡的
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //对称二叉树(给定一个二叉树，检查它是否是镜像对称的)
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree!=null || leftTree != null && rightTree==null) {
            return false;
        }
        if(leftTree == null && rightTree==null) {
            return true;
        }
        //比较根节点是不是相同，不相同就不是镜像
        //递归比较子树,左树的左子树和右树的右子树,
        //左树的右子树和右树的左子树是不是镜像
        if(leftTree.val != rightTree.val){
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right)&&
                isSymmetricChild(leftTree.right,rightTree.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
    //求一个二叉树的镜像
    public TreeNode MakeMirror(TreeNode root){
        //遍历+交换左右子树
        if(root==null){
            return null;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        MakeMirror(root.left);
        MakeMirror(root.right);
        return root;
    }
}
