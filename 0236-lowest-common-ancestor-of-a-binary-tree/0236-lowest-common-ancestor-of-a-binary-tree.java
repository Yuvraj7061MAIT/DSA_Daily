/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or either p or q is found, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursive calls to find the LCA in the left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both p and q are found in different subtrees, then root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one of p or q is found, return that node
        return leftLCA != null ? leftLCA : rightLCA;
    }
}