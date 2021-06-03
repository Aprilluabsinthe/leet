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
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        dfs(root,path,0,targetSum);
        return paths;
    }
    public void dfs(TreeNode node, List<Integer> path,int sum, int target){
        if(node == null){
            return ;
        }

        int nowValue = sum + node.val;
        path.add(node.val);
        if(node.left == null && node.right == null && nowValue ==target){
            paths.add(new ArrayList<>(path));
        }
        dfs( node.left,  path, nowValue,  target);
        dfs( node.right,  path, nowValue,  target);

        path.remove(path.size()-1);
    }

    /**
     * use Deque as data structure
     */
    List<List<Integer>> paths = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        dfs(root, sum);
        return paths;
    }

    public void dfs2(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if(root.left == null && root.right == null && target == 0){
            paths.add(new ArrayList<>(path));
        }
        dfs( root.left, target);
        dfs( root.right, target);
        path.pollLast();
    }
}