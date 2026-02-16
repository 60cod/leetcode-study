import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                // 중복 문자가 현재 윈도우 내부에 있을 경우만 이동
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    // 시간 복잡도: O(n) - 각 문자를 최대 2번 방문
    // 공간 복잡도: O(min(n, m)) - m은 문자 집합 크기

}
