/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
          if(head==null){
            return head;
          }

          Node cur=head;
          while(cur!=null){
            if(cur.child!=null){
                Node next=cur.next;
                cur.next=flatten(cur.child);
                cur.next.prev=cur;
                cur.child=null;
                while(cur.next!=null){
                    cur=cur.next;
                }
                if(next!=null){
                    cur.next=next;
                    next.prev=cur;
                }
            }
            else{
                cur=cur.next;
            }
          }
          return head;
        
    }
}