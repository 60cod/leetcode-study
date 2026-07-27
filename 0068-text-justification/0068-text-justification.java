import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int length = 0;

            while (j < words.length &&
                    length + words[j].length() + (j - i) <= maxWidth) {
                length += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(' ');
                    }
                }

                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                int totalSpaces = maxWidth - length;
                int spaces = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) {
                        for (int s = 0; s < spaces; s++) {
                            sb.append(' ');
                        }

                        if (extra > 0) {
                            sb.append(' ');
                            extra--;
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}

// 시간 복잡도 - O(n * maxWidth), n은 단어의 개수
// 공간 복잡도 - O(maxWidth), 반환 리스트 제외