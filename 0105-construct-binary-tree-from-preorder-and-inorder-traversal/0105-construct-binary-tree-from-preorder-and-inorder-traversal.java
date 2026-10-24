class Solution {
    private int preorderIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);
        int mid = inorderMap.get(value);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }

    // Time Complexity: O(n), where n is the number of nodes
    // Space Complexity: O(n), where n is the number of nodes
}