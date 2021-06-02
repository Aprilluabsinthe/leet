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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricTree(root.left,root.right);
    }

    public boolean isSymmetricTree(TreeNode ltree, TreeNode rtree) {
        if (ltree == null && rtree == null){
            return true;
        }
        if (ltree == null || rtree == null){
            return false;
        }
        if (ltree.val != rtree.val){
            return false;
        }
        return isSymmetricTree(ltree.left, rtree.right) && isSymmetricTree(ltree.right, rtree.left);
    }

    // Jun.2
    // compare with Q100,add an extra helper function
    // pre order
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricTree(root.left,root.right);
    }
    public boolean isSymmetricTree(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree == null){
            return true;
        }
        if(leftTree == null || rightTree == null || leftTree.val != rightTree.val){
            return false;
        }
        return isSymmetricTree(leftTree.right,rightTree.left) && isSymmetricTree(leftTree.left,rightTree.right);
    }

}