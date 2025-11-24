import java.util.PriorityQueue;
import java.util.HashSet;

class SmallestInfiniteSet {
    private int current;                       // 다음으로 반환할 자연수
    private PriorityQueue<Integer> minHeap;    // addBack으로 복원된 값
    private HashSet<Integer> inHeap;           // 중복 삽입 방지용 집합

    public SmallestInfiniteSet() {
        current = 1;
        minHeap = new PriorityQueue<>();
        inHeap = new HashSet<>();
    }

    public int popSmallest() {
        // 복원된 숫자가 우선순위 큐에 있다면 그중 가장 작은 값을 반환
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            inHeap.remove(smallest);
            return smallest;
        }

        // 아니면 아직 사용되지 않은 자연수 반환
        return current++;
    }

    public void addBack(int num) {
        // current보다 작은 값만 복원 가능
        // 이미 popSmallest로 제거된 값이어야 함
        if (num < current && !inHeap.contains(num)) {
            minHeap.offer(num);
            inHeap.add(num);
        }
    }
    // 시간 복잡도:
    // popSmallest: O(log n) — 우선순위 큐에서 최소값 제거 시
    // addBack: O(log n) — 힙에 삽입 시

    // 공간 복잡도: O(n) — 복원된 숫자 저장용 힙 및 집합
}
