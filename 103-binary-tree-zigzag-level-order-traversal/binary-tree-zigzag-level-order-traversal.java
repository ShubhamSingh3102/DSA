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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(root);
        int leftToRight = 1;

        while (!q.isEmpty()){
            int levelSize = q.size();

            ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(levelSize,0));

            // for zigzag traversal
            int first = 0;
            int last = levelSize - 1;

            while (levelSize --> 0){
                TreeNode t = q.peek();
                q.remove();


                if (leftToRight == 1){
                    temp.set(first,t.val);
                    first++;
                } else {
                    temp.set(last,t.val);
                    last--;
                }

                if(t.left != null){
                    q.add(t.left);
                }

                if(t.right != null){
                    q.add(t.right);
                }
            }
            res.add(temp);
            leftToRight = 1 - leftToRight;
        }
        return res;
    }
}