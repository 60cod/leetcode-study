class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j] = s[0..i-1]와 p[0..j-1]가 매치되는지 여부
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // 빈 문자열과 빈 패턴

        // 패턴이 '*'로 인해 빈 문자열과 매치되는 경우 초기화
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    // '*' 앞 문자가 반복되지 않음 OR '*' 앞 문자가 반복되는 경우
                    dp[i][j] = dp[i][j - 2] || 
                               ((p.charAt(j - 2) == sc || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

/*
시간 복잡도: O(m * n) - s 길이 m, p 길이 n 만큼 dp 테이블 채움
공간 복잡도: O(m * n) - dp 테이블 사용
*/