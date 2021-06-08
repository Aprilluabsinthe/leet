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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> memo = new HashMap<>();
        // return robHelper(root,memo);
        int[] res = rob_compressed(root);
        return Math.max( res[0] , res[1] );
    }

    public int robHelper(TreeNode root,HashMap<TreeNode,Integer> memo) {
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);

        int money = root.val;
        if(root.left != null){
            money += (robHelper(root.left.left,memo) + robHelper(root.left.right,memo));
        }
        if(root.right != null){
            money += (robHelper(root.right.left,memo) + robHelper(root.right.right,memo));
        }
        int result = Math.max(money, robHelper(root.left,memo) + robHelper(root.right,memo));
        memo.put(root,result);
        return result;
    }

    public int[] rob_compressed(TreeNode root) {
        int[] result = new int[2];
        if(root == null) return result;

        int[] left = rob_compressed(root.left);
        int[] right = rob_compressed(root.right);

        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    } 
}