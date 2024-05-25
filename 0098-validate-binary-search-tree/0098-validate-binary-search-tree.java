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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
        
//         // base case
//         if(root == null){
//             return true;
//         }
        
//         int min = maximum(root.left);
//         int max = minimum(root.right);
        
        
//         if(root.val <= min){
//             return false;
//         }
//         if(root.val >= max){
//             return false;
//         }
        
//         boolean Left = isValidBST(root.left);
//         booblean Right = isValidBST(root.right);
        
//         if(Left && Right) {
//             return true;
//         }else{
//             return false;
//         }
        
//     }
    
//     public static int maximum(){
//         if(root == null){
//             return Integer.MAX_VALUE;
//         }
//         return
//     }
    
//     public static int minimum(){
        
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        // Base case: An empty node is a valid BST
        if (node == null) {
            return true;
        }
        
        // Check the current node value against the bounds
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        // Recursively check the left and right subtrees with updated bounds
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}