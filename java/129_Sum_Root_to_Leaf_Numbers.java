package java;
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
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        return dfs(root,0);
    }

    public int dfs(TreeNode root, int prevTotal){
        if(root.left == null && root.right == null){
            return prevTotal * 10 + root.val;
        }
        int leftSum = 0;
        if(root.left != null){
            leftSum =  dfs( root.left, prevTotal * 10 + root.val );
        }
        int rightSum = 0;
        if(root.right != null){
            rightSum =  dfs( root.right, prevTotal * 10 + root.val );
        }
        return leftSum + rightSum;
    }
}