package package1;

class Node{
    public char value;
    public Node left;
    public Node right;

    public Node(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
public class BinaryTree {
    //根节点，当root为null的时候，就是一个空树
    private static Node root=null;
    //构建一棵树，构建成一个固定结构的树
    public static  Node build(){
        Node A=new Node('A');
        Node B=new Node('B');
        Node C=new Node('C');
        Node D=new Node('D');
        Node E=new Node('E');
        Node F=new Node('F');
        Node G=new Node('G');
        Node H=new Node('H');
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        E.right=H;
        C.left=F;
        C.right=G;
        return A;
    }
    //先序遍历,在递归的过程中，root是变化着的
    public static void prevOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.value);
        prevOrder(root.left);
        prevOrder(root.right);
    }
    //中序遍历
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value);
        inOrder(root.right);
    }
    //后序遍历
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value);
    }
    //遍历思路-求结点个数
    //前序遍历的修改，将打印变为size++,每打印一次,size++一次,打印的节点就是总节点个数
//  public static int treeSize=0;
//  public static void size(Node root){
//      if(root==null){
//          return;
//      }
//      treeSize++;
//      size(root.left);
//      size(root.right);
//  }
    //子问题思路-求结点个数
    public static int size(Node root){
        if(root==null){
            return 0;
        }
        //总结点个数=1(根节点)+左子树节点个数+右子树节点个数
        return 1+size(root.left)+size(root.right);
    }
    //遍历思路-求叶子结点个数
    //借助遍历的方式，访问节点的时候，先判断是不是叶子节点，如果是就++
//    public static int leafSize=0;
//    public static void getLeafSize(Node root){
//        if(root==null){
//            return;
//        }
//        //判断是否是叶子节点
//        if(root.left==null&&root.right==null){
//            leafSize++;
//        }
//        getLeafSize(root.left);
//        getLeafSize(root.right);
//    }
    // 子问题思路-求叶子结点个数
    public static int getLeafSize(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    // 子问题思路-求第 k 层结点个数
    public static int getKLevelSize(Node root,int k){
        if(root==null||k<1){
            return 0;
        }
        //k为1时，就一个根节点
        if(k==1){
            return 1;
        }
        //求第k层节点的个数可转换成求左子树的第k-1层节点的个数+右子树的k-1层节点的个数
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    public static Node find(Node root,char val){
        if(root==null){
            return null;
        }
        if(root.value==val){
            return root;
        }
        Node ret=find(root.left,val);
        if(ret!=null){
            return ret;//说明左子树找到了
        }
        Node ret1=find(root.right,val);
        if(ret1!=null){
            return ret1;//说明右子树找到了
        }
        return null;
    }
    public static void main(String[] args) {
        root=build();
        prevOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
//        size(root);
//        System.out.println(treeSize);
        System.out.println(size(root));
//        getLeafSize(root);
//        System.out.println(leafSize);
        System.out.println(getLeafSize(root));
        System.out.println(getKLevelSize(root,3));
        System.out.println(find(root,'E'));
    }
}
