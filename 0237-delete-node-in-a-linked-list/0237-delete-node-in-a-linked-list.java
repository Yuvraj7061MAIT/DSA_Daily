/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return; // Can't delete if node is null or last node
        }
        
        // Copy the value of the next node into the current node
        node.val = node.next.val;
        
        // Skip the next node by updating the current node's next reference
        node.next = node.next.next;
    }
}