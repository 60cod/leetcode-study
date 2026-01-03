import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 종료 시간 기준 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int remove = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 겹치는 경우 제거
            if (intervals[i][0] < prevEnd) {
                remove++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return remove;
    }
    // 시간 복잡도: O(n log n) - 정렬 비용
    // 공간 복잡도: O(1) - 정렬 외 추가 공간 없음 (in-place)
}
