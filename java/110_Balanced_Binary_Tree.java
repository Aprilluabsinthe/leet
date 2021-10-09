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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int L = 0;
        int R = 0;
        L = getHeight(root.left);
        R = getHeight(root.right);
        if(L == -1 || R == -1 || Math.abs(L-R) > 1) return false;
        return true;
    }
    
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int L = 0;
        int R = 0;
        L = getHeight(root.left);
        R = getHeight(root.right);
        
        if(L==-1 || R == -1 || Math.abs(L-R) > 1) return -1;
        
        return Math.max(L,R)+1;
    }
}