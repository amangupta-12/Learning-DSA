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
    public ListNode swapPairs(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (len >= 2) {
            ListNode curr = prev.next;

            ListNode var = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = var;

            prev = curr;
            len = len - 2;
        }

        return dummy.next;
    }
}