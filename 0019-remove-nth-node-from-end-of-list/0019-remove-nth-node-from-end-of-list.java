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
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;  
      ListNode temp = head;
      int len = 0;
      while(temp!=null){
        temp = temp.next;
        len++;
      }
        temp = dummy;
      for(int i=0;i<len-n;i++){
        temp = temp.next;
      }
      if(temp.next!=null){
        temp.next = temp.next.next;
      }else{
        temp.next = null;
      }

    return dummy.next;
    }
}