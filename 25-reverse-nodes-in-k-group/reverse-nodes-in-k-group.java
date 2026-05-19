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
    public void reverse(ListNode head,int times){
        ListNode curr = head;
        ListNode prev = null;

        while(times-- > 0){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode left = head;
        ListNode right;
        ListNode res = null;
        ListNode prevLeft = null;
        int size = k;

        while(true) {
            right = left;
            for(int i = 0; i < (size-1); i++){
                if(right == null){
                    break;
                }
                right = right.next;
            }
            if(right != null){
                ListNode nextLeft = right.next;
                reverse(left,size);

                // now for connection
                if(prevLeft != null){
                    prevLeft.next = right;
                }
                prevLeft = left;
                if(res == null){
                    res = right;  // newHead
                }
                left = nextLeft;
            } else {  // right == null // akela element baacha h...
                if(prevLeft != null){
                    prevLeft.next = left;
                }
                if(res == null){
                    res = left;
                }
                break;
            }
        }
        return res;
    }
}