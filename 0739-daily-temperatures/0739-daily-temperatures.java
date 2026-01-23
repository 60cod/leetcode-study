import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        // 인덱스를 저장하는 단조 감소 스택
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 현재 온도가 더 높으면 이전 날짜 처리
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }

        return answer;
    }
    // 시간 복잡도: O(n) - 각 인덱스는 스택에 한 번 push, 한 번 pop
    // 공간 복잡도: O(n) - 스택 사용

}
