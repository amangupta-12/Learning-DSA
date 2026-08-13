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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev =  dummy;
        ListNode curr =  head;
        int dup = 0;
        while(curr!=null && curr.next!=null){
            if(curr.val != curr.next.val){
                prev = curr;
                curr = curr.next;
            }else{
                dup =  curr.val;
                while(curr!=null && curr.val == dup){
                    curr = curr.next;
                }
                prev.next = curr;
            }
        }
        // if((prev.next.next!=null) && (dup == prev.next.next.val)) prev.next = null;
        return dummy.next;
    }
}