import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // 여러 자리 수 처리
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(current);
                current = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}

/*
Time Complexity: O(n)
 - 문자열 한 번 순회하며, 각 문자당 상수 시간 연산

Space Complexity: O(n)
 - Stack과 결과 문자열 저장에 O(n) 공간 사용
*/
