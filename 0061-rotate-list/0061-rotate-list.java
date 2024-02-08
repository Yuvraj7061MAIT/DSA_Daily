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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // If the list is empty, has only one node, or k is 0, no rotation needed
        }
        
        int length = 1;
        ListNode tail = head;
        // Calculate the length of the list and find the tail node
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        
        // Adjust k to be within the range [0, length)
        k = k % length;
        if (k == 0) {
            return head; // If k is a multiple of the length, no rotation needed
        }
        
        // Find the new head and new tail after rotation
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        
        // Break the list at the newTail and reconnect it at the end of the original list
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
}
