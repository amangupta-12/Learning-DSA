class Solution {
    public boolean isPalindrome(ListNode head) {

      ListNode slow = head;
      ListNode fast = head;
     
      while(fast!=null && fast.next!=null){
        fast =  fast.next.next;
        slow = slow.next;
      }
      
      if(fast!=null){  // this is an odd length linked list 
        slow = slow.next;
      }

// Here we revised the half List 
      ListNode prev = null;
      while(slow!=null){
        ListNode next = slow.next;
        slow.next = prev;
        prev = slow;
        slow = next;
      }

    ListNode first =  head;
    ListNode second =  prev;

      while(second!=null){
        if(second.val != first.val){
            return false;
        }
        second = second.next;
        first = first.next;
      }

      return true;
    }
}