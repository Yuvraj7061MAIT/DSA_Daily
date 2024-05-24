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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                root.val = minValue(root.right);
                // Delete the inorder successor
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    // Helper function to find the minimum value in a BST
    private int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            root = root.left;
            minv = root.val;
        }
        return minv;
    }
}