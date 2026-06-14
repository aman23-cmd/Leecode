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
    public int pairSum(ListNode head) {
        List<Integer>ls= new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            ls.add(temp.val);
            temp=temp.next;
        }
        int left=0;
        int right=ls.size()-1;
        int max=Integer.MIN_VALUE;
        while(left<right){
            int currSum=ls.get(left++)+ls.get(right--);
            if(currSum>max)max=currSum;
        }
        return max;
    }
}