
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTree(1, n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            List<TreeNode> rightTrees = generateTree(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    allTrees.add(new TreeNode(i,left,right));
                }
            }
        }
        return allTrees;
    }
}