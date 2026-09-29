class Solution {
    public List<TreeNode> generateTrees(int n) {
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int rootValue = start; rootValue <= end; rootValue++) {
            List<TreeNode> leftTrees = buildTrees(start, rootValue - 1);
            List<TreeNode> rightTrees = buildTrees(rootValue + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    // Time Complexity: O(Cn * n), where Cn is the nth Catalan number
    // Space Complexity: O(Cn * n)
}