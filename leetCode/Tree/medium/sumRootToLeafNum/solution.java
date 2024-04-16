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
    public int recurseAdd(TreeNode node, int headsum) {
        if (node == null) {
            return 0;
        }

        headsum = headsum*10 + node.val;

        if (node.left ==null && node.right==null) {
            return headsum;
        } else {
            return recurseAdd(node.left, headsum) + recurseAdd(node.right,
                headsum);
        }

    }
    public int sumNumbers(TreeNode root) {
        return recurseAdd(root, 0);
    }

}

// This is a depth first search solution. recruseAdd function may just as well be named DFS