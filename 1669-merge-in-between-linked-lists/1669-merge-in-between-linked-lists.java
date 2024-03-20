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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;

        // Find the (a-1)th node in list1
        for (int i = 0; i < a - 1; i++) {
            curr = curr.next;
        }

        ListNode prevB = curr;

        // Find the bth node in list1
        for (int i = 0; i < b - a + 1; i++) {
            prevB = prevB.next;
        }

        // Connect the (a-1)th node to the head of list2
        if (curr != null) {
            curr.next = list2;
        }

        // Find the last node in list2
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Connect the last node of list2 to the node after the bth node in list1
        tail.next = prevB.next;

        // Set the next of prevB to null to detach the bth node and nodes after it
        prevB.next = null;

        return list1;
    }
}
