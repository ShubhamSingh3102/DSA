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
    static TreeNode prev = null;
    static boolean ans = true;  // maan lo validate h
    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        inOrder(root.left);
        // work
        if (prev == null){
            prev = root;
        } else {
            if (root.val <= prev.val){
                ans = false;
            }
            prev = root;
        }

        inOrder(root.right);

    }
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        prev = null;
        ans = true;

        inOrder(root);
        return ans;
    }
}