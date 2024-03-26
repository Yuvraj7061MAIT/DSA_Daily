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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode leftSubtree, TreeNode rightSubtree) {
        // If both subtrees are null, they are symmetric
        if (leftSubtree == null && rightSubtree == null) {
            return true;
        }
        // If only one subtree is null, they are not symmetric
        if (leftSubtree == null || rightSubtree == null) {
            return false;
        }
        // If the values of the current nodes are different, they are not symmetric
        if (leftSubtree.val != rightSubtree.val) {
            return false;
        }
        // Recursively check if the left subtree of the left subtree is symmetric to the right subtree of the right subtree
        // and if the right subtree of the left subtree is symmetric to the left subtree of the right subtree
        return isMirror(leftSubtree.left, rightSubtree.right) && isMirror(leftSubtree.right, rightSubtree.left);
    }
}