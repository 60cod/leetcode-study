import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // 두 문자열에서 사용된 문자 집합이 동일해야 함
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] > 0) || (freq1[i] > 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // 빈도 배열을 정렬하여 비교
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}

/*
Time Complexity: O(n + k log k)
 - n: 문자열 길이 순회
 - k=26: 빈도 정렬 (상수, 무시 가능)
 - 전체 O(n)

Space Complexity: O(1)
 - 길이 26짜리 배열만 사용
*/
