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

    public int sumNumbers(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        Deque<Pair<TreeNode,Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root,0));
        
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> cur = stack.pop();
            root = cur.getKey();
            currNumber = cur.getValue();
            
            if(root != null){
               currNumber = currNumber * 10 + root.val;
                if (root.left == null && root.right == null){
                    rootToLeaf += currNumber;
                }else{
                    stack.push(new Pair(root.left,currNumber));
                    stack.push(new Pair(root.right,currNumber));
                }  
            }
        }
        return rootToLeaf;
    }
}