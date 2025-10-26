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
    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);  // 시작 방향: 왼쪽
        dfs(root, false, 0); // 시작 방향: 오른쪽
        return maxLen;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        maxLen = Math.max(maxLen, length);

        if (isLeft) {
            dfs(node.left, false, length + 1); // 방향 전환
            dfs(node.right, true, 1);          // 새 경로 시작
        } else {
            dfs(node.right, true, length + 1); // 방향 전환
            dfs(node.left, false, 1);          // 새 경로 시작
        }
    }
}

/*
Time Complexity: O(n)
 - 모든 노드를 한 번씩 방문

Space Complexity: O(h)
 - 재귀 호출 스택 사용 (h는 트리 높이, 최악의 경우 O(n))
*/
