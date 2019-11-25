package package1;

import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test {
    //二叉树的前序遍历，非递归迭代实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                list.add(cur.val);
                cur=cur.left;
            }
            cur=stack.pop();
            cur=cur.right;
        }
        return list;
    }
    //二叉树的中序遍历，非递归迭代实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            System.out.print(cur.val+" ");
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }
    //二叉树的后序遍历，非递归迭代实现
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode falg=null;//falg为判断是不是重新打印的标记
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //说明此时cur为空，此时cur需要拿到栈顶元素看是否有右子树
            //有两种情况:cur.right==null,cur.right!=null
            cur=stack.peek();
            if(cur.right==null||cur.right==falg){
                System.out.print(cur.val+" ");
                list.add(cur.val);
                stack.pop();
                falg=cur;
                cur=null;
            } else{
                cur=cur.right;
            }
        }
        return list;
    }
    // 二叉树的分层遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return ret;
        }
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int count=queue.size();
            List<Integer> list=new ArrayList<>();//每一层的数据
            while(count>0){
                TreeNode cur=queue.poll();
                System.out.print(cur.val+" ");
                list.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                count--;
            }
            ret.add(list);
        }
        return ret;
    }
    // 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode leftTree=lowestCommonAncestor(root.left,p,q);
        //leftTree是往左递归第一个p或者q
        TreeNode rightTree=lowestCommonAncestor(root.right,p,q);
        if(leftTree!=null&&rightTree!=null){//说明p和q分别在左树和右树中
            return root;
        }
        if(leftTree!=null&&rightTree==null){//说明p和q都在左树
            return leftTree;
        }
        if(leftTree==null&&rightTree!=null){//说明p和q都在右树
            return rightTree;
        }
        return null;
    }
    //二叉搜索树转换成排序双向链表(中序遍历),不能创建任何新的结点，只能调整树中结点指针的指向
    //二叉树是三个域,双向链表也是三个域,prev->left,next->right
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertChild(pRootOfTree);//构建双向链表
        //返回头结点
        TreeNode head=pRootOfTree;
        while(head!=null&&head.left!=null){
            head=head.left;
        }
        return head;
    }
    public TreeNode prev=null;
    public void ConvertChild(TreeNode root){
        if(root==null){
            return;
        }
        ConvertChild(root.left);//左树已经结束
        //根节点
        root.left=prev;
        while(prev!=null){
            prev.right=root;
        }
        prev=root;
        ConvertChild(root.right);//右树
    }
    //根据一棵树的前序遍历与中序遍历构造二叉树,可以假设树中没有重复的元素
    public int preIndex=0;//前序遍历的下标
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeChild(int[] preorder,int[] inorder,
                                   int inbegin,int inend){
        //inbegin和inend为在中序中找到前序的节点后，查找左子树和右子树的范围
        if(inbegin>inend){//说明这个节点没有左子树和右子树
            return null;
        }
        //把前序遍历到的第一个节点定义为根节点
        TreeNode root=new TreeNode(preorder[preIndex]);
        //找到root在中序遍历数组中的位置
        int rootIndex=findInorderIndex(inorder,inbegin,inend,preorder[preIndex]);
        if(rootIndex==-1){
            return null;
        }
        //找到了
        preIndex++;
        root.left=buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right=buildTreeChild(preorder,inorder,rootIndex+1,inend);
        return root;
    }
    //找到前序的节点在中序当中的位置
    public int findInorderIndex(int[] inorder,int inbegin,int inend,int val){
       for(int i=inbegin;i<=inend;i++) {
           if(inorder[i]==val){
               return i;
           }
       }
       return -1;
    }
    //根据一棵树的中序遍历与后序遍历构造二叉树
    public int posIndex=0;
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0){
            return null;
        }
        posIndex=postorder.length-1;
        //posIndex只要定义在buildTreeChild1方法外面，就是全局变量
        return buildTreeChild1(postorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeChild1(int[] postorder,int[] inorder,
                                   int inbegin,int inend){
        if(inbegin>inend){
            return null;
        }
        TreeNode root=new TreeNode(postorder[posIndex]);
        int rootIndex=findInorderIndex1(inorder,inbegin,inend,postorder[posIndex]);
        if(rootIndex==-1){
            return null;
        }
        posIndex--;
        root.right=buildTreeChild1(postorder,inorder,rootIndex+1,inend);
        root.left=buildTreeChild1(postorder,inorder,inbegin,rootIndex-1);
        return root;
    }
    public int findInorderIndex1(int[] inorder,int inbegin,int inend,int val){
        for(int i=inbegin;i<=inend;i++) {
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    //二叉树创建字符串
    //需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    //空节点则用一对空括号"()"表示,而且需要省略
    //所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
    public String tree2str(TreeNode t) {
        StringBuilder sb=new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }
    public void tree2strChild(TreeNode t,StringBuilder sb) {//t为根，即root
        if (t == null) {
            return;
        }
        sb.append(t.val);
        if (t.left == null) {
            if (t.right == null) {//左右都为空
                return;
            } else {//左为空，右不为空
                sb.append("()");
            }
        } else {//左不为空
            sb.append("(");
            tree2strChild(t.left, sb);
            sb.append(")");
        }
        if (t.right == null) {//左不为空，右为空
            return;
        } else {//左不为空，右也不为空
            sb.append("(");
            tree2strChild(t.right, sb);
            sb.append(")");
        }
    }
}
