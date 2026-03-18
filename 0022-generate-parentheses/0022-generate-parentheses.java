import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // '(' 추가 가능
        if (open < n) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        // ')' 추가 가능 (닫는 괄호는 항상 여는 괄호보다 적어야 함)
        if (close < open) {
            sb.append(')');
            backtrack(result, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/*
시간 복잡도: O(4^n / sqrt(n)) - 카탈란 수 개수만큼 생성
공간 복잡도: O(n) - 재귀 호출 스택 및 문자열 생성
*/