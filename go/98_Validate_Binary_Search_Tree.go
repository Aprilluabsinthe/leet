/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isValidBST(root *TreeNode) bool {
	return helper(root, math.MinInt64, math.MaxInt64)
}

func helper(root *TreeNode, low int, upper int) bool {
	if root == nil {
		return true
	}
	if root.Val <= low || root.Val >= upper {
		return false
	}
	return helper(root.Left, low, root.Val) && helper(root.Right, root.Val, upper)
}

func isValidBST2(root *TreeNode) bool {
	stack := []*TreeNode{}
	inorder := math.MinInt64

	for len(stack) > 0 || root != nil {
		for root != nil {
			stack = append(stack, root)
			root = root.Left
		}
		root = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if root.Val <= inorder {
			return false
		}
		inorder = root.Val
		root = root.Right
	}
	retrun true
}