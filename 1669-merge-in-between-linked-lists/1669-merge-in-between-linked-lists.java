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
        ListNode prevA=null;
        ListNode afterB=null;
        ListNode temp=list1;
        int index=0;
        while(temp!=null){
            if(index==a-1){
                prevA=temp;
            }
            if(index==b){
                afterB=temp.next;
            }
            temp=temp.next;
            index++;

        }
        prevA.next=list2;
        ListNode tail=list2;
        while(tail.next!=null) {
            tail=tail.next;
        }
        tail.next=afterB;
        return list1;
    }
}