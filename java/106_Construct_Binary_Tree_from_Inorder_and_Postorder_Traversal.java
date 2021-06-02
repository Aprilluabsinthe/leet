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
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0 ; i < n ; i++){
            indexMap.put(inorder[i],i);
        }
        return constructTree(inorder,0,n-1,postorder,0,n-1);
    }

    public TreeNode constructTree(int[] inorder, int inStart, int inEnd, int[] postorder,int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = indexMap.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = constructTree(inorder,inStart,inStart+numLeft-1,postorder,postStart,postStart+numLeft-1);
        root.right = constructTree(inorder,inRoot+1,inEnd,postorder,postStart+numLeft,postEnd-1);

        return root;
    }
}