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
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        res = false; // reset

        if (root == null) {
            return false;
        }
        helper(root, 0, targetSum);

        return res;
    }

    public void helper(TreeNode root, int sum, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;

        // leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                res = true;
            }
            return;
        }

        // non-leaf

        helper(root.left, sum, target);
        helper(root.right, sum, target);
    }
}