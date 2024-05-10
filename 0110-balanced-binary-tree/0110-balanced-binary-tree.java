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
    public boolean isBalanced(TreeNode root) {
        // Base case
        if (root == null) {
            return true;
        }
        
        // Check the height of the left subtree
        int leftHeight = height(root.left);
        
        // Check the height of the right subtree
        int rightHeight = height(root.right);
        
        // Check if the absolute difference in height is greater than 1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        // Recursively check if both left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    // Helper method to calculate the height of a subtree
    private int height(TreeNode node) {
        // Base case
        if (node == null) {
            return 0;
        }
        
        // Calculate the height of the left subtree
        int leftHeight = height(node.left);
        
        // Calculate the height of the right subtree
        int rightHeight = height(node.right);
        
        // Return the maximum height between left and right subtrees, plus 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
