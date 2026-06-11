class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}

// 시간 복잡도 - O(n), n은 문자열 s의 길이
// 공간 복잡도 - O(1)