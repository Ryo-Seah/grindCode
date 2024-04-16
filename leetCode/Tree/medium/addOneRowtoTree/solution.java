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
    public void recurse(TreeNode node, int val, int depth, int curr_depth) {

        if (depth - 1 != curr_depth) {
            if (node != null) {
                recurse(node.left, val, depth, curr_depth+1);
                recurse(node.right, val, depth, curr_depth+1);
            }
            
        } else if (node != null) {
            TreeNode temp_left = node.left;
            TreeNode temp_right = node.right;
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
            
        }
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        recurse(root, val, depth, 1);
        return root;
    }
}

// recurse, take note if node is null and if depth ==1