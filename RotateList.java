package neetcode.linkedList;

public class RotateList {
    class ListNode{
       ListNode next;
       int val;
       ListNode(int val){
           this.val = val;

       }
    }
    public ListNode rotateList(ListNode head , int k){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode ot = head;
        int n = 1;
        while (ot.next!= null) {
            ot = ot.next;
            n++;
        }
        ot.next = head;

        ListNode newTail = head;
        for (int i = 0; i <  n - k % n - 1 ; i++)
            newTail = newTail.next;
            ListNode newHead = newTail.next;
            newTail.next =null;
            return newHead;
    }

}
