class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        int n1 = word1.length(), n2 = word2.length();

        // 교차로 문자 추가
        while (i < n1 && j < n2) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        // 남은 문자 처리
        if (i < n1) result.append(word1.substring(i));
        if (j < n2) result.append(word2.substring(j));

        return result.toString();
    }
}

/*
Time Complexity: O(n1 + n2)
 - 두 문자열을 한 번씩 순회

Space Complexity: O(n1 + n2)
 - 결과 문자열 저장용 StringBuilder 사용
*/
