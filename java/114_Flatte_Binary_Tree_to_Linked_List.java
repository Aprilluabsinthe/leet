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
    public TreeNode preRoot = new TreeNode();
    public void flatten(TreeNode root) {
        preorder(root);
        root = preRoot.right;
    }
    /**
     * DFS
     * @param curNode
     */
    public void preorder(TreeNode curNode){
        if(curNode == null){
            return;
        }

        TreeNode ll = curNode.left;
        TreeNode rr = curNode.right;

        preRoot.left = null;
        preRoot.right = curNode;
        preRoot = curNode;

        preorder(ll);
        preorder(rr);
    }

    /**
     * recursive
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode ll = root.left;
        TreeNode rr = root.right;

        
        flatten(ll);
        flatten(rr);
        root.left = null;
        root.right = ll;
        TreeNode cursor = root;
        while(cursor.right != null){
            cursor = cursor.right;
        }
        cursor.right = rr;
    }
}