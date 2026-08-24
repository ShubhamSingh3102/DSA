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
    static int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;

        if (root == null) {
            return 0;
        }

        helper(root);

        return res;
    }

    public static int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int sum = left + right;

        res = Math.max(res, sum); // diameter update

        // height return
        return 1 + Math.max(left, right);
    }
}