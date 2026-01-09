class Solution {
    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        // dp[i]: 2 x i 보드를 완전히 채우는 경우의 수
        // dp2[i]: 2 x i 보드에서 한 칸이 돌출된 상태(지그재그)로 채우는 경우의 수
        long[] dp = new long[n + 2];
        long[] dp2 = new long[n + 2];

        dp[0] = 1;   // 빈 보드
        dp[1] = 1;   // 세로 도미노 1개
        dp2[1] = 0;

        for (int i = 2; i <= n; i++) {
            // 완전히 채우는 경우
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * dp2[i - 1]) % MOD;
            // 한 칸 돌출 상태
            dp2[i] = (dp2[i - 1] + dp[i - 2]) % MOD;
        }

        return (int) dp[n];
    }
    // 시간 복잡도: O(n) - 1차원 DP
    // 공간 복잡도: O(n) - dp, dp2 배열 사용
}
