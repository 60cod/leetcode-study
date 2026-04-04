import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> target = new HashMap<>();
        for (String w : words) {
            target.put(w, target.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (target.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > target.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}

// 시간 복잡도 - O(n * m), n은 문자열 s의 길이, m은 단어 길이
// 공간 복잡도 - O(k), k는 words의 고유 단어 개수