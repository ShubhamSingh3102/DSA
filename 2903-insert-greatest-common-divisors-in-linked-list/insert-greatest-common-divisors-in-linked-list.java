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
    public static int GreatestCommonDivisor(ListNode head1, ListNode head2){
        if(head1 == null){
            return 0;
        }
        if (head2 == null){
            return 0;
        }

        if((head1.val > head2.val) && head1.val % head2.val == 0){
            return head2.val;
        }

        if((head1.val < head2.val) && head2.val % head1.val == 0){
            return head1.val;
        }

        int a = head1.val;
        int b = head2.val;

        return findGCD(a,b);
    }

    public static int findGCD(int a, int b){
        return (b == 0) ? a : findGCD(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode temp = head;

        while (temp.next != null){
            ListNode curr = temp;
            ListNode next = curr.next;

            ListNode newNode = new ListNode(GreatestCommonDivisor(curr, next));

            curr.next = newNode;
            newNode.next = next;

            temp = next;
        }

        return head;
    }
}