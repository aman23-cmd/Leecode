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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null &&fast.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        prev.next=null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeSort(l1, l2);
    }
    public ListNode mergeSort(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0); // Dummy node
    ListNode p = l;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1 != null) {
      p.next = l1;
    }
    if (l2 != null) {
      p.next = l2;
    }
    return l.next;
  }
}