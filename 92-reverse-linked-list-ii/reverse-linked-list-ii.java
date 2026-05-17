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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        int pos = 1;
        ListNode before = null;
        ListNode t = head;

        while (pos < left) {
            before = t;
            t = t.next;
            pos++;
        }
        // pos = left
        // now reverse till right
        ListNode curr = t;
        ListNode prev = null;
        int times = right - left + 1;

        while (times-- > 0) {
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        // now connection
        t.next = curr;

        if(before != null){
            before.next = prev;
            return head;
        } else {
            return prev;
        }
    }
}