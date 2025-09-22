class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        
        return dp;
    }
    // Time Complexity: 시간: O(n) (한 번 순회)
    // Space Complexity: 공간: O(n) (배열 dp[n+1])
}
