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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int answerLevel = 1;

        while (q.size() > 0) {
            int size = q.size();
            int sum = 0;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                sum += temp.val;

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                answerLevel = level;
            }
        }
        return answerLevel;
    }
}