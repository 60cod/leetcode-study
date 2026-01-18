import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;

        // 앞쪽, 뒤쪽 후보용 최소 힙
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int l = 0;
        int r = n - 1;

        // 초기 후보 채우기
        for (int i = 0; i < candidates && l <= r; i++) {
            leftHeap.offer(costs[l++]);
        }
        for (int i = 0; i < candidates && l <= r; i++) {
            rightHeap.offer(costs[r--]);
        }

        // k번 채용
        for (int i = 0; i < k; i++) {
            if (rightHeap.isEmpty() ||
                (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {

                total += leftHeap.poll();
                if (l <= r) {
                    leftHeap.offer(costs[l++]);
                }
            } else {
                total += rightHeap.poll();
                if (l <= r) {
                    rightHeap.offer(costs[r--]);
                }
            }
        }

        return total;
    }
    // 시간 복잡도: O(n log candidates)
    //   - 각 원소는 최대 한 번 힙에 들어가고, k번 poll 수행
    // 공간 복잡도: O(candidates)
    //   - 좌우 힙에 최대 candidates개 저장
}
