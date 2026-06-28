/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     TreeNode prev = null;
     TreeNode g1First = null;
     TreeNode g1second = null;
     TreeNode g2First = null;
     TreeNode g2second = null;
     int galat = 0;
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        inOrder(root.left);

        // work
        if (prev == null){
            prev = root;
        } else {
            //// prev != null
            if (root.val <= prev.val) {  // galti
                if (galat == 0){  // phela galat
                    g1First = prev;
                    g1second = root;
                    galat++;
                } else {
                    //// dusri galati
                    g2First = prev;
                    g2second = root;
                    galat++;
                }
            }
            prev = root;
        }

        inOrder(root.right);
    }
    public void swap(TreeNode p,TreeNode q){
        int temp = p.val;
        p.val = q.val;
        q.val = temp;

        return;
    }
    public void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }

        prev = null;
        g1First = null;
        g1second = null;
        g2First = null;
        g2second = null;
        galat = 0;

        inOrder(root);

        if (galat == 1){
            swap(g1First,g1second);
        } else {
            // galat == 2
            swap(g1First,g2second);
        }
        return;
    }
}