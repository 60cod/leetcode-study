class Solution {
    public boolean isNumber(String s) {
        boolean hasNum = false;
        boolean hasDot = false;
        boolean hasExp = false;
        boolean numAfterExp = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                hasNum = true;
                numAfterExp = true;
            } else if (c == '.') {
                if (hasDot || hasExp) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasExp || !hasNum) {
                    return false;
                }
                hasExp = true;
                numAfterExp = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return hasNum && numAfterExp;
    }
}

// 시간 복잡도 - O(n), n은 문자열 s의 길이
// 공간 복잡도 - O(1)