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
        // Handle edge cases where head is null or k is 1
        if (head == null || k == 1) return head;

        // Create a dummy node to serve as the previous node before the current group
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers for previous and current nodes
        ListNode prev = dummy, curr = head;

        // Variable to keep track of the count of nodes processed
        int count = 0;

        // Loop through the list
        while (curr != null) {
            count++;

            // If count is a multiple of k, reverse the current group
            if (count % k == 0) {
                // Reverse the current group and update prev to the new group's end
                prev = reverse(prev, curr.next);
                // Move curr to the next group's starting node
                curr = prev.next;
            } else {
                // Move curr to the next node
                curr = curr.next;
            }
        }

        // Return the modified list
        return dummy.next;
    }

    // Method to reverse a group of nodes between start and end (exclusive)
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start.next;
        ListNode curr = prev.next;

        while (curr != end) {
            ListNode next = curr.next;
            curr.next = start.next;
            start.next = curr;
            curr = next;
        }

        prev.next = end;
        return prev;
    }
}