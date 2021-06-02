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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        tranversal(root, 0);
        return ans;
    }
    public void tranversal(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(new ArrayList<Integer>());
        }

        if((level & 1) == 1){
            ans.get(level).add(0,root.val);
        }
        else{
            ans.get(level).add(root.val);
        }
        tranversal(root.left,level+1);
        tranversal(root.right,level+1);
    }
}