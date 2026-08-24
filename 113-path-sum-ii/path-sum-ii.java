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
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> diary = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res.clear();
        diary.clear();

        if (root == null) {
            return new ArrayList<>();
        }

        helper(root, 0, targetSum, diary);

        return res;
    }

    public static void helper(TreeNode root, int sum, int targetSum, List<Integer> diary) {

        if (root == null) {
            return;
        }

        sum += root.val;
        diary.add(root.val);

        // leaf
        if (root.left == null && root.right == null) {

            if (sum == targetSum) {
                res.add(new ArrayList<>(diary));
            }

            diary.remove(diary.size() - 1);
            return;
        }

        // non-leaf
        helper(root.left, sum, targetSum, diary);
        helper(root.right, sum, targetSum, diary);

        // BACKTRACK
        diary.remove(diary.size() - 1);
    }
}