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
/**
 * pretty much like 103
 * remember to create new arraylists in each layer
 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        tranversal(root,0);
        return ans;
    }

    public void tranversal(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        tranversal(root.left,level+1);
        tranversal(root.right,level+1);
    }
}