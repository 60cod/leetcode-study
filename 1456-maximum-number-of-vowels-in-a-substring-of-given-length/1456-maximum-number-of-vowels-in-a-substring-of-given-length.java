class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int currentCount = 0;
        int n = s.length();

        // Helper function: 모음 판별
        java.util.Set<Character> vowels = java.util.Set.of('a', 'e', 'i', 'o', 'u');

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) currentCount++;
        }
        maxCount = currentCount;

        // 슬라이딩 윈도우 이동
        for (int i = k; i < n; i++) {
            if (vowels.contains(s.charAt(i))) currentCount++;
            if (vowels.contains(s.charAt(i - k))) currentCount--;
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}

/*
Time Complexity: O(n)
 - 문자열을 한 번 순회하면서 윈도우를 이동.

Space Complexity: O(1)
 - 상수 공간 (모음 집합과 변수만 사용).
*/
