/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If there are less than two nodes, there can't be a cycle
        }
        
        // Detect cycle using Floyd's Tortoise and Hare algorithm
        ListNode tortoise = head;
        ListNode hare = head;
        boolean hasCycle = false;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                hasCycle = true;
                break;
            }
        }
        
        // If there's no cycle, return null
        if (!hasCycle) {
            return null;
        }
        
        // Find the node where the cycle begins
        tortoise = head;
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        
        return tortoise;
    }
}
