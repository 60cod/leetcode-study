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

import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1); // 누적합 0은 한 번 존재한다고 가정
        return dfs(root, 0, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSum) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = prefixSum.getOrDefault(currentSum - targetSum, 0);

        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, currentSum, targetSum, prefixSum);
        count += dfs(node.right, currentSum, targetSum, prefixSum);

        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1); // 백트래킹

        return count;
    }
}

/*
Time Complexity: O(n)
 - 각 노드를 한 번씩 방문하며 해시맵 조회/갱신은 O(1)

Space Complexity: O(h)
 - 재귀 깊이(트리 높이) 및 해시맵 저장 공간. 평균 O(log n), 최악 O(n)
*/
