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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTravel(root, result);
        return result;
    }
    
    public void inorderTravel(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        inorderTravel(node.left, result);
        
        result.add(node.val);
        
        inorderTravel(node.right, result);
    }
}