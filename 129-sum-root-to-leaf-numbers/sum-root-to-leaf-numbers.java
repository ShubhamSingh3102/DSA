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

    public int sumNumbers(TreeNode root) {
        
        res = 0;

        if(root == null){
            return 0;
        }

        helper(root,0);

        return res;
    }

    public static void helper(TreeNode root,int sum){
        if(root == null){
            return;
        }

        sum = sum * 10 + root.val;

        // leaf
        if(root.left == null && root.right == null){
            res += sum;
            return;
        }

        helper(root.left,sum);
        helper(root.right,sum);
    }
}