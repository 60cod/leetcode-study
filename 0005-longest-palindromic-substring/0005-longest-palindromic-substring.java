class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++) {
            // 홀수 길이 팰린드롬
            int len1 = expand(s, i, i);
            // 짝수 길이 팰린드롬
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 팰린드롬 길이
    }
    // 시간 복잡도: O(n^2) - 각 중심에서 양쪽 확장
    // 공간 복잡도: O(1) - 추가 공간 사용 없음

}
