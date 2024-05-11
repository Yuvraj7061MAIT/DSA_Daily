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

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            // One of the trees is empty while the other is not, they are not identical
            return false;
        }
        if (p.val != q.val) {
            // Values of the current nodes don't match, they are not identical
            return false;
        }
        // Recursively check left and right subtrees
        boolean leftSame = isSameTree(p.left, q.left);
        boolean rightSame = isSameTree(p.right, q.right);
        // Both subtrees should be identical for the trees to be the same
        return leftSame && rightSame;
    }
}