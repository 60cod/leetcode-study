import java.util.*;

class StockSpanner {

    // 스택에는 [가격, 해당 가격의 span] 저장
    // 가격은 단조 감소 유지
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        // 현재 가격보다 작거나 같은 이전 가격들은 모두 흡수
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }
    // 시간 복잡도: O(1) amortized
    //   - 각 가격은 스택에 한 번 push, 한 번 pop
    // 공간 복잡도: O(n)
    //   - 최악의 경우 모든 가격이 스택에 저장
}
