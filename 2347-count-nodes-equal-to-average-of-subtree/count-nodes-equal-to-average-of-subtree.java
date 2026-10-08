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
    int count = 0;

    public int averageOfSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.val == average(root)) {
            count++;
        }

        averageOfSubtree(root.left);
        averageOfSubtree(root.right);

        return count;
    }

    public int numberOfNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);
    }

    public int average(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = root.val;

        sum += getSum(root.left);
        sum += getSum(root.right);

        return sum / numberOfNodes(root);
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }
}