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
    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode result;
        if(list1.val<list2.val){
            result=list1;
            result.next=merge(list1.next,list2);

        }else{
            result=list2;
             result.next=merge(list1,list2.next);

        }
        return result;
        
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode firstHalf=head;
        ListNode slow =head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=slow.next;
        slow.next=null;
        firstHalf=sortList(firstHalf);
        secondHalf=sortList(secondHalf);
        ListNode ans=merge(firstHalf,secondHalf);
        return ans;
        
    }
}