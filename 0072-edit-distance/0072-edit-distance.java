class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j]: word1[0..i-1] -> word2[0..j-1] 최소 연산 횟수
        int[][] dp = new int[m + 1][n + 1];

        // 초기화: 한쪽이 빈 문자열일 경우 삽입/삭제 연산 필요
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 문자가 같으면 연산 필요 없음
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // 교체
                        Math.min(
                            dp[i - 1][j],   // 삭제
                            dp[i][j - 1]    // 삽입
                        )
                    );
                }
            }
        }

        return dp[m][n];
    }
    // 시간 복잡도: O(m*n) - 2중 반복문
    // 공간 복잡도: O(m*n) - dp 배열 사용

}
