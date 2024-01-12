# Day 14: Binary tree Part 02

## 102

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
    public List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // dfs(root, 0);
        bfs(root);
        return result;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null)
            return;

        level++;

        if (result.size() < level) {
            List<Integer> item = new ArrayList<Integer>();
            result.add(item);
        }
        result.get(level - 1).add(node.val);
        dfs(node.left, level);
        dfs(node.right, level);
    }

    public void bfs(TreeNode node){
        if(node == null) return;

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while(!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
  
            int len = que.size();

            while(len > 0){
                TreeNode tmp = que.poll();
                list.add(tmp.val);
                if(tmp.left != null) que.offer(tmp.left);
                if(tmp.right != null) que.offer(tmp.right);
                len--;
            }
            result.add(list);
        }
    }
}
```

## [107. Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

### DFS

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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root, 0);
        List<List<Integer>> reverse = new ArrayList<>();

        for (int i = result.size() - 1; i >= 0; i--) {
            reverse.add(result.get(i));
        }
        return reverse;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null)
            return;

        if (result.size() == level) {
            List<Integer> newList = new ArrayList<>();
            result.add(newList);
        }
        result.get(level).add(node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);

    }
}
```

### BFS

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 利用链表可以进行 O(1) 头部插入, 这样最后答案不需要再反转
        LinkedList<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                temp.add(node.val);

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }

            // 新遍历到的层插到头部, 这样就满足按照层次反序的要求
            ans.addFirst(temp);
        }

        return ans;
    }
}

```

## [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

### BFS

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (i == size - 1)
                    result.add(tmp.val);

                if (tmp.left != null)
                    queue.offer(tmp.left);
                if (tmp.right != null)
                    queue.offer(tmp.right);

            }

        }

        return result;

    }
}
```

Can also optimize by adding right kid first

```java
                if (i == 0)
                    result.add(tmp.val);

                if (tmp.right != null)
                    queue.offer(tmp.right);
                if (tmp.left != null)
                    queue.offer(tmp.left);
```

## [637. Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/)

Pay attention to the range of Integer.

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
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            double levelSum = 0; // DO NOT USE INTEGER

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                levelSum += tmp.val ;

                if (tmp.left != null)
                    queue.offer(tmp.left);
                if (tmp.right != null)
                    queue.offer(tmp.right);
            }

            result.add(1.0 * levelSum / size);

        }

        return result;

    }
}
```
