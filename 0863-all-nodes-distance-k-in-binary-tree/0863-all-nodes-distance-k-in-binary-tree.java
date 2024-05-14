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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParent(root, null, parentMap);
        findNodesAtKDistance(target, k, parentMap, result, new HashSet<>());
        return result;
    }
    
    private void findParent(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        parentMap.put(node, parent);
        findParent(node.left, node, parentMap);
        findParent(node.right, node, parentMap);
    }
    
    private void findNodesAtKDistance(TreeNode node, int k, Map<TreeNode, TreeNode> parentMap, List<Integer> result, Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        if (k == 0) {
            result.add(node.val);
            return;
        }
        if (node.left != null) findNodesAtKDistance(node.left, k - 1, parentMap, result, visited);
        if (node.right != null) findNodesAtKDistance(node.right, k - 1, parentMap, result, visited);
        TreeNode parent = parentMap.get(node);
        if (parent != null) findNodesAtKDistance(parent, k - 1, parentMap, result, visited);
    }
}