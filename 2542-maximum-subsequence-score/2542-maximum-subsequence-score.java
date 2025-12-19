import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // nums2의 값 기준 내림차순 정렬, 인덱스 추적
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Integer.compare(nums2[b], nums2[a]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            minHeap.offer(nums1[idx]);
            sum += nums1[idx];

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                long score = sum * (long) nums2[idx];
                maxScore = Math.max(maxScore, score);
            }
        }

        return maxScore;
    }
    // 시간 복잡도: O(n log n) - 정렬 O(n log n) + 우선순위 큐 삽입/제거 O(n log k)
    // 공간 복잡도: O(n) - 인덱스 배열 및 힙
}
