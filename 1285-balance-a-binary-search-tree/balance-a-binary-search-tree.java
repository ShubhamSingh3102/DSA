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

    // Inorder → sorted array...
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Build balanced BST from sorted list
    public TreeNode buildBST(List<Integer> list, int low, int high){
        if(low > high) return null;

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = buildBST(list, low, mid - 1);
        root.right = buildBST(list, mid + 1, high);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return buildBST(list, 0, list.size() - 1);
    }
}
