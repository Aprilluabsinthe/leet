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

## [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

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
    Map<Integer, Integer> map; // inorder value to index map

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {// [inclusive, exclusive)
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]); // find the latest element in post order
        TreeNode root = new TreeNode(inorder[rootIndex]); // construct the node
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);
        return root;

    }
}
```



## [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

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
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);

    }

    public TreeNode findNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd <= preStart || inEnd <= inStart) {
            return null;
        }

        int rootIndex = map.get(preorder[preStart]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int leftLen = rootIndex - inStart;

        root.left = findNode(preorder, preStart + 1, preStart + leftLen + 1, inorder, inStart, rootIndex);
        root.right = findNode(preorder, preStart + leftLen + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;

    }
}
```

## NOTE

If needs to visit all the recursion, do not need return value. VOID is fine.-> 113

If nees to cut and no need to visit all recursions, needs to ues return value to control where to end. -> 113
