class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // 현재 문자열과 prefix가 일치할 때까지 prefix 줄이기
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
    // 시간 복잡도: O(n * m)
    //   - n: 문자열 개수
    //   - m: prefix 최대 길이
    // 공간 복잡도: O(1) - 추가 자료구조 사용 없음

}
