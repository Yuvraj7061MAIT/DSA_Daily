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
    private int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return diameter;
    }
    
    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);
        
        // Update the diameter if the sum of the depths of left and right subtrees is greater
        diameter = Math.max(diameter, leftDepth + rightDepth);
        
        // Return the depth of the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}