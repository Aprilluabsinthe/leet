# Day 16: Binary tree Part 03

## [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

### Postorder Traversal

Postorder Traversal is used for calculation max HEIGHT.

(left- rigt - mid)

But ROOT's  max HEIGHT = ROOT's DEPTH.

We can use Postorder Traversal;

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }
}
```



### preorder traversal

If it is not root, we should use preorder to calculate depth. (mid- left - right)

```cpp
class Solution {
public:
    int result;
    void getDepth(TreeNode* node, int depth) {
        result = depth > result ? depth : result; // 中

        if (node->left == NULL && node->right == NULL) return ;

        if (node->left) { // 左
            depth++;    // 深度+1
            getDepth(node->left, depth);
            depth--;    // 回溯，深度-1
        }
        if (node->right) { // 右
            depth++;    // 深度+1
            getDepth(node->right, depth);
            depth--;    // 回溯，深度-1
        }
        return ;
    }
    int maxDepth(TreeNode* root) {
        result = 0;
        if (root == NULL) return result;
        getDepth(root, 1);
        return result;
    }
};
```

## [559. Maximum Depth of N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int sizeChild = root.children.size();
        int max = 0;

        for (int i = 0; i < sizeChild; i++) {
            int childDepth = maxDepth(root.children.get(i));
            max = Math.max(max, childDepth);
        }
        return max + 1;
    }
}
```

## [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

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
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public int min(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null) {
            // left is null
            return 1 + min(root.right);
        } else if (root.right == null) {
            // right is null
            return 1 + min(root.left);
        }

        // left right all exist
        return 1 + mins(root.left);
    }
}
```

## [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

### For all Binary Trees

```
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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = countNodes(root.left);
        int rightDepth = countNodes(root.right);
        return leftDepth + rightDepth + 1;
    }
}
```

### for Complete Tree

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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;

        int leftDepth = 0, rightDepth = 0;

        while (left != null) {
            left = left.left;
            leftDepth++;
        }

        while (right != null) {
            right = right.right;
            rightDepth++;
        }

        if(leftDepth == rightDepth){
            return (2 << leftDepth) - 1; // 2 * (2 ^ left)
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
```

## Note

1. Pay attention to the defination of "min depth of the binary tree".

![111.二叉树的最小深度](https://code-thinking.cdn.bcebos.com/pics/111.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E6%B7%B1%E5%BA%A6.png)

2. Complete Tree

level (start from 0)

node number for full tree is : `(2 << level) -1` = `2 * (2 ^ level) - 1`;

![](https://code-thinking-1253855093.file.myqcloud.com/pics/20200920221638903-20230310123444151.png)
