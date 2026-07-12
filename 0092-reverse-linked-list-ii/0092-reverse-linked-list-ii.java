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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        // Move prev to the node before the left-th node
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        ListNode curr = prev.next;
        
        // Reverse the sublist from left to right
        for (int i = 1; i <= right - left; i++) {
            ListNode temp = prev.next; // 0
            prev.next = curr.next; // 1
            curr.next = curr.next.next; // 2
            prev.next.next = temp; // 3
        }
    
        return dummy.next;
    }
}
