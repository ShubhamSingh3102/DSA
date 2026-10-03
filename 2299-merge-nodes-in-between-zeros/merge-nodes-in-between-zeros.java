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
    public ListNode mergeNodes(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.val == 0 && head.next ==  null){
            return head;
        }

        ListNode temp = head;

        while (temp.next != null){
            ListNode next = temp.next;
            int sum = 0;
            while (next.val != 0){
                sum += next.val;
                next = next.next;
            }

            ListNode newNode = new ListNode(sum);

            temp.next = newNode;
            newNode.next = next;  // next zero pr tha...
            temp = next;
        }

        ListNode result;

        if(head.val == 0){
            result = head.next;
        } else {
            result = head;
        }

        ListNode curr = result;
        while (curr != null && curr.next != null){
            if(curr.next.val == 0){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return result;
    }
}