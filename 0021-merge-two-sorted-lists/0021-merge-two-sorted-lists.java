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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy =  new ListNode(-1);
        ListNode tail =  dummy;        
        ListNode one = list1;
        ListNode two = list2; 

        while(one!=null && two!=null){
          if(one.val  <= two.val){
           tail.next = one;
           one =  one.next;
          }else{
            tail.next = two;
            two  = two.next;
          }
          tail = tail.next;
        }
        while(one!=null){
            tail.next =  one;
            one = one.next;
            tail = tail.next;
        }
         while(two!=null){
            tail.next =  two;
            two = two.next;
            tail = tail.next;
        }

        return dummy.next;
    }
}