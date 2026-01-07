import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // 끝 좌표 기준 오름차순 정렬
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int arrows = 1;
        long end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // 현재 화살로 커버 불가능한 경우
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
    // 시간 복잡도: O(n log n) - 정렬
    // 공간 복잡도: O(1) - 정렬 외 추가 공간 없음

}
