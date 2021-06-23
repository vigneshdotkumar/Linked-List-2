/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null )    
            return;
        if(head.next==null)
            return;
        //middle
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //reverse
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        
        //merge
        while(fast!=null)
        {
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
        
    }
    public ListNode reverse(ListNode head)
    {
         ListNode prev=null;
         ListNode curr=head;
         ListNode fast=head.next;
        while(fast!=null)
        {
           curr.next=prev;
           prev=curr;
           curr=fast;
            fast=fast.next;
            
        }
        curr.next=prev;
     return curr;
    }
   
}