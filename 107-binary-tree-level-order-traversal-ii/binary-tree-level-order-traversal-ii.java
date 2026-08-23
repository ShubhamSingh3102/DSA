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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()){
            int leveLSize = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            while (leveLSize --> 0){
                TreeNode t = q.peek();
                q.remove();

                temp.add(t.val);

                if(t.left != null){
                    q.add(t.left);
                }

                if(t.right != null){
                    q.add(t.right);
                }
            }
            res.add(temp);
        }

        Collections.reverse(res);
        return res;
    }
}