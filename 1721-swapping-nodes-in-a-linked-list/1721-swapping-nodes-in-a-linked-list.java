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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1=head;// for finding position of k from beginning 
        for(int i=1;i<=k-1;i++){
            temp1=temp1.next;
        }

        ListNode slow=head;
        ListNode fast=head;
        for(int i=1;i<=k-1;i++){
            fast=fast.next;
        }
        
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode temp=new ListNode(temp1.val);
        temp1.val=slow.val;
        slow.val=temp.val;

        return head;
        
    }
}