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
    public static void InOrder1(TreeNode root1, ArrayList<Integer> res){
        if(root1 == null){
            return;
        }
        InOrder1(root1.left, res);
        res.add(root1.val);
        InOrder1(root1.right, res);
    }

    public static void InOrder2(TreeNode root2, ArrayList<Integer> ans){
        if(root2 == null){
            return;
        }
        InOrder2(root2.left, ans);
        ans.add(root2.val);
        InOrder2(root2.right,ans);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        InOrder1(root1, res);
        InOrder2(root2, ans);

        // now merge sort
        int i = 0;
        int j = 0;

        ArrayList<Integer> finalAns = new ArrayList<>();

        while (i < res.size() && j < ans.size()) {
            if (res.get(i) > ans.get(j)) {
                finalAns.add(ans.get(j));
                j++;
            } else {
                finalAns.add(res.get(i));
                i++;
            }
        }

        while (i < res.size()){
            finalAns.add(res.get(i));
            i++;
        }

        while (j < ans.size()){
            finalAns.add(ans.get(j));
            j++;
        }
        return finalAns;
    }
}