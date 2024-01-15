# Day 17: Binary tree Part 04

## [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)

### level order traversal

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                // Leaf level.
                if (i == 0) {
                    res = tmp.val;
                }

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }

        }
        return res;

    }
}
```

### Reversion

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
    private int deepest = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    public void findLeftValue(TreeNode node, int deep) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            if (deep > deepest) {
                deepest = deep;
                value = node.val;
            }
        }

        if (node.left != null)
            findLeftValue(node.left, deep + 1);
        if (node.right != null)
            findLeftValue(node.right, deep + 1);

    }
}
```

## [112. Path Sum](https://leetcode.com/problems/path-sum/)

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return traversal(root, targetSum - root.val);
    }

    public boolean traversal(TreeNode node, int count) {
        if (node.left == null && node.right == null && count == 0) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return false;
        }

        if (node.left != null) { // left
            count -= node.left.val;
            if (traversal(node.left, count))
                return true;
            count += node.left.val;
        }

        if (node.right != null) {// right
            count -= node.right.val;
            if (traversal(node.right, count))
                return true;
            count += node.right.val;
        }
        return false;
    }
}
```

## [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/)

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetSum, res, path);
        return res;
    
    }

    public void preorderdfs(TreeNode node, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(node.val);
        // left
        if (node.left == null && node.right == null) {
            if (targetSum - node.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // if leaf and sum != target, stop here;
        }

        if (node.left != null) {
            preorderdfs(node.left, targetSum - node.val, res, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            preorderdfs(node.right, targetSum - node.val, res, path);
            path.remove(path.size() - 1);
        }

    }
}
```
