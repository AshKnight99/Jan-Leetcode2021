/*
Remove Duplicates from Sorted List II
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
 Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

*/
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;
        // Iterate over nodes
        while (head != null) {
            int val = head.val;
            // Check if duplicate value
            if (head.next != null && val == head.next.val) {
                // Remove duplicate values
                while (head != null && val == head.val)
                    head = head.next;
                prev.next = head;
                }
            else {
                // No duplicate so move to next
                prev = head;
                head = head.next;
            }
        }
        return newHead.next;
        
    }
}