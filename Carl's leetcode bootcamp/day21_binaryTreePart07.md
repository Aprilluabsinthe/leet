# Day 21: Binary tree Part 07

## [530. Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)

Two Pointer for binary tree

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> nodeValues = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);

        int minDiff = Integer.MAX_VALUE;
        Collections.sort(nodeValues);

        for (int i = 0; i < nodeValues.size() - 1; i++) {
            minDiff = Math.min(minDiff, nodeValues.get(i + 1) - nodeValues.get(i));
        }
        return minDiff;

    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;

        nodeValues.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
```
