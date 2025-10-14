class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.deleteCharAt(stack.length() - 1); // 가장 최근 문자 제거
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }
}

/*
Time Complexity: O(n)
 - 문자열을 한 번 순회하며 각 문자 처리

Space Complexity: O(n)
 - 결과를 저장하기 위한 StringBuilder 사용
*/
