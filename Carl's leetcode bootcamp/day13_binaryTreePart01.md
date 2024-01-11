# Day 13: Binary tree Part 01

A binary tree is **a tree-type non-linear data structure with a maximum of two children for each parent**. Every node in a binary tree has a left and right reference along with the data element. The node at the top of the hierarchy of a tree is called the root node. The nodes that hold other sub-nodes are the parent nodes.

![Binary Tree](https://cdn.programiz.com/sites/tutorial2program/files/binary_tree_1.png)

## Types of Binary Tree

![](https://images2015.cnblogs.com/blog/1094457/201702/1094457-20170225184451991-1942362001.png)

### 1. Full Binary Tree

A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.

![Full binary tree](https://cdn.programiz.com/sites/tutorial2program/files/full-binary-tree_0.png)

### 2. Perfect Binary Tree

A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.

![Perfect binary tree](https://cdn.programiz.com/sites/tutorial2program/files/perfect-binary-tree_0.png)

### 3. Complete Binary Tree

A complete binary tree is just like a full binary tree, but with two major differences

1. Every level must be completely filled
2. All the leaf elements must lean towards the left.
3. The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.

![Complete Binary Tree](https://cdn.programiz.com/sites/tutorial2program/files/complete-binary-tree_0.png)

### 4. Degenerate or Pathological Tree

A degenerate or pathological tree is the tree having a single child either left or right.

![Degenerate Binary Tree](https://cdn.programiz.com/sites/tutorial2program/files/degenerate-binary-tree_0.png)

### 5. Skewed Binary Tree

A skewed binary tree is a pathological/degenerate tree in which the tree is either dominated by the left nodes or the right nodes. Thus, there are two types of skewed binary tree: **left-skewed binary tree** and **right-skewed binary tree**.

![Skewed Binary Tree](https://cdn.programiz.com/sites/tutorial2program/files/skewed-binary-tree_0.png)

### 6. Balanced Binary Tree

It is a type of binary tree in which the difference between the height of the left and the right subtree for each node is either 0 or 1.

![Balanced Binary Tree](https://cdn.programiz.com/sites/tutorial2program/files/height-balanced_1.png)


| **完美二叉树** | Perfect Binary Tree | Every node except the leaf nodes have two children and every level (last level too) is completely filled.**除了叶子结点之外的每一个结点都有两个孩子，每一层(当然包含最后一层)都被完全填充。** |
| - | - | - |
| **完全二叉树** | Complete Binary Tree | Every level except the last level is completely filled and all the nodes are left justified.**除了最后一层之外的其他每一层都被完全填充，并且所有结点都保持向左对齐。** |
| **完满二叉树** | Full/Strictly Binary Tree | Every node except the leaf nodes have two children.**除了叶子结点之外的每一个结点都有两个孩子结点。** |

## Binary Search Tree

### What is Binary Search Tree?

**Binary Search Tree** is a node-based binary tree data structure which has the following properties:

* The left subtree of a node contains only nodes with keys lesser than the node’s key.
* The right subtree of a node contains only nodes with keys greater than the node’s key.
* The left and right subtree each must also be a binary search tree.

![Binary Search Tree](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20221215114732/bst-21.png)

### AVL Tree

In computer science, an AVL tree (named after inventors Adelson-Velsky and Landis) is **a self-balancing binary search tree**. In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one, rebalancing is done to restore this property.

## Binary Tree Representation

A node of a binary tree is represented by a structure containing a data part and two pointers to other structures of the same type.

```
struct node
{
 int data;
 struct node *left;
 struct node *right;
};
```

```java
// Node creation
class Node {
  int key;
  Node left, right;

  public Node(int item) {
  key = item;
  left = right = null;
  }
}
```

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```
