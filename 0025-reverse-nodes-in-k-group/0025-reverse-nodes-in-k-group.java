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

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        
        // Count the number of nodes in the current group
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        
        // If the current group has k nodes, reverse it
        if (count == k) {
            // Reverse the first k nodes of the group
            ListNode reversedHead = reverse(head, k);
            
            // Recursively reverse the rest of the list
            head.next = reverseKGroup(current, k);
            return reversedHead;
        }
        
        // If the number of nodes is less than k, no reversal is needed
        return head;
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        
        // Reverse the first k nodes of the group
        while (k > 0) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
            k--;
        }
        
        return prev;
    }
}
