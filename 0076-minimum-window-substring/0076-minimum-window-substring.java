class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];

        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0;
        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (count[c] > 0) {
                required--;
            }
            count[c]--;

            while (required == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left++);

                count[leftChar]++;
                if (count[leftChar] > 0) {
                    required++;
                }
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}

// 시간 복잡도 - O(m + n), m은 문자열 s의 길이, n은 문자열 t의 길이
// 공간 복잡도 - O(1)