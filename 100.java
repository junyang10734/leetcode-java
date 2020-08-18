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


// Recursion
// faster than 100.00%
class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (q == null || p == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}


// Iteration
// faster than 100.00%
class Solution2 {
    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(q == null || p == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(!check(p,q)){
            return false;
        }

        ArrayDeque<TreeNode> depP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> depQ = new ArrayDeque<TreeNode>();
        depP.addLast(p);
        depQ.addLast(q);

        while(!depP.isEmpty()){
            p = depP.removeFirst();
            q = depQ.removeFirst();

            if(!check(p,q)){
                return false;
            }

            if(p!=null){
                if(!check(p.left,q.left)){
                    return false;
                }
                if(p.left != null){
                    depP.addLast(p.left);
                    depQ.addLast(q.left);
                }
                if(!check(p.right, q.right)){
                    return false;
                }
                if(p.right != null){
                    depP.addLast(p.right);
                    depQ.addLast(q.right);
                }
            }
        }
        return true;
    }
}