class Solution {

    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();

    public TreeNode getSmall(){

        if(asc.empty()){
            return null;
        }

        TreeNode small = asc.pop();

        TreeNode rightChild = small.right;

        while(rightChild != null){
            asc.push(rightChild);
            rightChild = rightChild.left;
        }

        return small;
    }

    public TreeNode getBig(){

        if(desc.empty()){
            return null;
        }

        TreeNode big = desc.pop();

        TreeNode leftChild = big.left;

        while(leftChild != null){
            desc.push(leftChild);
            leftChild = leftChild.right;
        }

        return big;
    }

    public boolean findTarget(TreeNode root, int k) {

        if(root == null){
            return false;
        }

        TreeNode t = root;

        // Push all left nodes
        while(t != null){
            asc.push(t);
            t = t.left;
        }

        t = root;

        // Push all right nodes
        while(t != null){
            desc.push(t);
            t = t.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while(i != null && j != null && i != j && i.val < j.val){

            int sum = i.val + j.val;

            if(sum == k){
                return true;
            }

            if(sum > k){
                j = getBig();
            }
            else{
                i = getSmall();
            }
        }

        return false;
    }
}