/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // 각 깊이에서 처음 방문한 노드가 오른쪽 끝 노드
        if (depth == result.size()) result.add(node.val);

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}

/**
 * Time Complexity: O(n)
 *  - 모든 노드를 정확히 한 번씩 방문
 *
 * Space Complexity: O(h)
 *  - 재귀 호출 스택의 깊이 (h는 트리의 높이)
 */
