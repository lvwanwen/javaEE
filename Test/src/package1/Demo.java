package package1;

class Node {
     int data;
     Node next;

     public Node(int data) {
         this.data = data;
     }
 }
 public class Demo{
     public Node FindKthToTail(Node head,int k){
         int len=size(head);
         if(head==null||k<0||k>len){
             return null;
         }
         int offset=len-k;
         Node cur=head;
         for(int i=0;i<offset;i++){
             cur=cur.next;
         }
         return cur;
     }
     private int size(Node head){
         int size=0;
         for(Node cur=head;cur!=null;cur=cur.next){
             size++;
         }
         return size;
     }
     public Node mergeTwoLists(Node l1, Node l2){
         if(l1==null){
             return l2;
         }
         if(l2==null){
             return l1;
         }
         Node cur1=l1;
         Node cur2=l2;
         Node newHead=null;
         Node newTail=null;
         while(cur1!=null&&cur2!=null) {
             if (cur1.data < cur2.data) {
                 if (newHead == null) {
                     newHead = cur1;
                     newTail = cur1;
                     cur1 = cur1.next;
                 } else {
                     newHead.next = cur1;
                     newTail.next = cur1;
                     cur1 = cur1.next;
                 }
             } else if (cur1.data > cur2.data) {
                 if (newHead == null) {
                     newHead = cur2;
                     newTail = cur2;
                     cur2 = cur2.next;
                 } else {
                     newHead.next = cur2;
                     newTail.next = cur2;
                     cur2 = cur2.next;
                 }
             }
             if (cur1 == null) {
                 newTail.next = cur2;
             }
             if (cur2 == null) {
                 newTail.next = cur1;
             }
         }
         return newHead;
     }
     public Node reverseList(Node head){
         if(head==null){
             return null;
         }
         if(head.next==null){
             return head;
         }
         Node cur=head;
         Node prev=null;
         Node newHead=null;
         while(cur!=null){
             Node next=cur.next;
             if(next==null){
                 newHead=cur;
             }
             cur.next=prev;
             prev=cur;
             cur=next;
         }
         return newHead;
     }
 }

