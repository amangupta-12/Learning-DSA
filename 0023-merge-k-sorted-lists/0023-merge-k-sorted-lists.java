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
 class Solution{
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

private ListNode partition(ListNode[] lists, int low, int high) {

    if(low == high){
        return lists[low];
    }

    int mid = low + (high - low) / 2;

    ListNode left = partition(lists, low, mid);
    ListNode right = partition(lists, mid + 1, high);

    return mergeTwoLists(left, right);
}


    public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0){
        return null;
    }
    return partition(lists, 0, lists.length - 1);
}
}