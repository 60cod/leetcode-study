import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // 최소 힙(PriorityQueue) 사용: 노드 값 기준으로 정렬
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                heap.offer(node.next);
            }
        }

        return dummy.next;
    }
}

/*
시간 복잡도: O(N log k) - N은 모든 노드 합, k는 리스트 개수, 힙 연산 log k
공간 복잡도: O(k) - 힙에 최대 k개 노드 저장
*/