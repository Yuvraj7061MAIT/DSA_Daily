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
    public ListNode reverseList(ListNode head) {
        // Base case: if head is null or head is the last node, return head
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the sublist starting from the next node
        ListNode reversed = reverseList(head.next);
        
        // Reverse the pointers
        head.next.next = head;  // Reverse the pointer of the next node to point back to the current node
        head.next = null;       // Set the current node's next pointer to null
        
        // Return the new head of the reversed list
        return reversed;
    }
}
