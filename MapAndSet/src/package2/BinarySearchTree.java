package package2;
//二叉搜索树
public class BinarySearchTree {
    static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    //插入,只会插入到叶子节点
    public Node root=null;
    public void insert(int key){
        Node node=new Node(key);
        if(root==null){
            root=node;
            return;
        }
        Node cur=root;
        Node parent=null;//记录父节点
        while(cur!=null){
            if(cur.val==key){
                return;//不插入
            }
            if(key<cur.val){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        //找到要插入节点的父节点了
        if(parent.val<key){
            parent.right=node;
        }else{
            parent.left=node;
        }
    }
    //用前序遍历和中序遍历构造一个二叉搜索树
    public void prevOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        prevOrder(root.left);
        prevOrder(root.right);
    }
    public void InOrder(Node root) {
        if(root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.val+" ");
        InOrder(root.right);
    }
    //查找
    public Node search(int key){
        if(root==null){
            return null;
        }
        Node cur=root;
        while(cur!=null){
            if(cur.val==key){
                return cur;
            }
            if(key>cur.val){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return null;
    }
    //删除
    //parent是要删除节点的父节点,cur为要删除的节点
    public void remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.val==key){
                removeNode(parent,cur);
            }
            if(cur.val<key){
                parent=cur;
                cur=cur.right;
            }else{
                parent=cur;
                cur=cur.left;
            }
        }
    }
    public void removeNode(Node parent,Node cur){
        if(cur.left==null){
            if(cur==root){
               root=cur.right;
            }else if(cur==parent.left){
                parent.left=cur.right;
            }else{
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else{//cur.left!=null&&cur.right!=null
            //找到cur左子树中的最大值(左子树中最右下角的节点),或者
            //找到cur右子树中的最小值(右子树中最左下角的节点)覆盖cur,在删除这个值
            Node targetParent = cur;//target的父节点
            Node target = cur.right;//右子树中的最小值
            while(target.left!=null){
                targetParent=target;
                target=target.left;
            }
            cur.val=target.val;
            if(target==targetParent.left){
                targetParent.left=target.right;
            }else{
                targetParent.right=target.right;
            }
        }
    }
}
