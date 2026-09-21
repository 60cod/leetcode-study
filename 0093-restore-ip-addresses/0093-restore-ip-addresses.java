import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(
            String s,
            int start,
            int parts,
            StringBuilder current,
            List<String> result
    ) {
        if (parts == 4) {
            if (start == s.length()) {
                result.add(current.toString());
            }
            return;
        }

        int remainingDigits = s.length() - start;
        int remainingParts = 4 - parts;

        if (remainingDigits < remainingParts || remainingDigits > remainingParts * 3) {
            return;
        }

        int length = current.length();

        for (int end = start; end < Math.min(start + 3, s.length()); end++) {
            if (end > start && s.charAt(start) == '0') {
                break;
            }

            int value = Integer.parseInt(s.substring(start, end + 1));

            if (value > 255) {
                break;
            }

            if (parts > 0) {
                current.append('.');
            }

            current.append(value);
            backtrack(s, end + 1, parts + 1, current, result);
            current.setLength(length);
        }
    }
}

// 시간 복잡도 - O(3^4), 최대 4개의 구간을 각각 최대 3자리까지 탐색
// 공간 복잡도 - O(1), 재귀 스택과 현재 문자열을 위한 추가 공간, 반환 리스트 제외