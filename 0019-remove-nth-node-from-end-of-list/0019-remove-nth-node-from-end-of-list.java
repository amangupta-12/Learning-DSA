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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) return null;
    ListNode temp = head;
    int len = 0;
    while(temp!=null){
        temp  = temp.next;
        len++;
    }
temp = head;
    for(int i = 0 ; i<len - n-1 ; i++){
        temp = temp.next;
    }
    if(len - n - 1 < 0) return head.next;

    if(temp!= null && temp.next != null){
        temp.next = temp.next.next;
    }

    return head;
    }
}