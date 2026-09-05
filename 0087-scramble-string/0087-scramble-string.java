class Solution {
    private String s1;
    private String s2;
    private Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        this.s1 = s1;
        this.s2 = s2;

        int n = s1.length();
        memo = new Boolean[n][n][n + 1];

        return dfs(0, 0, n);
    }

    private boolean dfs(int i, int j, int len) {
        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }

        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return memo[i][j][len] = true;
        }

        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return memo[i][j][len] = false;
            }
        }

        for (int split = 1; split < len; split++) {
            // No swap: A | B -> A' | B'
            if (dfs(i, j, split)
                    && dfs(i + split, j + split, len - split)) {
                return memo[i][j][len] = true;
            }

            // Swap: A | B -> B' | A'
            if (dfs(i, j + len - split, split)
                    && dfs(i + split, j, len - split)) {
                return memo[i][j][len] = true;
            }
        }

        return memo[i][j][len] = false;
    }
}

// 시간 복잡도 - O(n^4), n은 문자열의 길이
// 공간 복잡도 - O(n^3), n은 문자열의 길이