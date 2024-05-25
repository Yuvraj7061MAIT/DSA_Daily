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
        TreeNode parent = null;
        TreeNode current = root;
        
        // Search for the node to delete
        while (current != null && current.val != key) {
            parent = current;
            if (key < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        if (current == null) {
            // Key not found, return the original root
            return root;
        }
        
        // Case 1: Node to be deleted has no children (leaf node)
        if (current.left == null && current.right == null) {
            if (current != root) {
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                root = null;
            }
        }
        // Case 2: Node to be deleted has only one child
        else if (current.left == null) {
            if (current != root) {
                if (parent.left == current) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else {
                root = current.right;
            }
        } else if (current.right == null) {
            if (current != root) {
                if (parent.left == current) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else {
                root = current.left;
            }
        }
        // Case 3: Node to be deleted has two children
        else {
            // Find the inorder successor (smallest node in the right subtree)
            TreeNode successor = findSuccessor(current.right);
            
            // Copy the inorder successor's value to the current node
            current.val = successor.val;
            
            // Delete the inorder successor node
            current.right = deleteNode(current.right, successor.val);
        }
        
        return root;
    }
    
    private TreeNode findSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
