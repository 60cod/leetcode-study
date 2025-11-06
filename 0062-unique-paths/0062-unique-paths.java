class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 첫 행과 첫 열은 모두 1 (오직 한 방향으로만 이동 가능)
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // 점화식: dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

/*
Time Complexity: O(m * n)
 - DP 테이블을 한 번 완전히 채움

Space Complexity: O(m * n)
 - 2D DP 배열 사용.
 - 공간 최적화 시 O(n)으로도 가능
*/
