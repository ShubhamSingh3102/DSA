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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;   // mechanic
        ListNode prev = null;   // helper

        while(curr != null){
            ListNode nex = curr.next; // jab connection tutega to ye aage jump krne ke liye kaam aaega...
            curr.next = prev;  // for connection
            prev = curr;
            curr = nex;
        }
        return prev;
    }
}