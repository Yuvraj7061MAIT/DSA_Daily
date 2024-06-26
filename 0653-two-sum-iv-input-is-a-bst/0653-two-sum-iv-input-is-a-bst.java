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
    public boolean findTarget(TreeNode root, int k) {
        
        HashSet<Integer> seen = new HashSet<>();
        return sum(root , k , seen);
    }
    
     private boolean sum(TreeNode root, int k, HashSet<Integer> seen){
         
         if(root == null){
             return false;
         }
         
         if(seen.contains(k-root.val)){
             return true;
         }
         
         seen.add(root.val);
         
         
         return sum(root.left , k , seen) || sum(root.right , k , seen);
     }
}