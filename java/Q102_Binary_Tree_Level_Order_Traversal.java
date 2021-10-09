public /**
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
   public List<List<Integer>> levelOrder(TreeNode root) {
       if(root == null) return new ArrayList<List<Integer>>();
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       Deque<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       
       while(!queue.isEmpty()){
           int levelcount = queue.size();
           List<Integer> thislevel = new ArrayList<>();
           int index = 0;
           while(index < levelcount){
               TreeNode cur = queue.pollFirst();
               thislevel.add(cur.val);
               if(cur.left!=null) queue.addLast(cur.left);
               if(cur.right!=null) queue.addLast(cur.right);
               index++;
           }
           result.add(thislevel);
       }
       return result;
   }
   
}class Q102_Binary_Tree_Level_Order_Traversal {
    
}
