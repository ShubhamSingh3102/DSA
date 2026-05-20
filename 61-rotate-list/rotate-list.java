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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int n = 1;
        ListNode last = head;

        while(last.next != null){
            n++;
            last = last.next;
        }

        k = k % n;
        if(k == 0){
            return head;
        }

        int count = 1;
        int c = (n - k);
        ListNode t = head;

        while(t != null){
            if(count == c){
                break;
            }
            count++;
            t = t.next;
        }

        // for (n- k +1)
        ListNode res = t.next;

        // now connection
        last.next = head;

        t.next = null;

        return res;
    }
}