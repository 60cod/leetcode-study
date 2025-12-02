import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // 초기 상태 수집: 썩은 오렌지를 큐에 넣고 신선한 오렌지 개수 파악
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // 신선한 오렌지가 없으면 바로 0
        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // BFS: 1분 단위로 신선한 오렌지가 썩음
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            minutes++;

            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    if (grid[nx][ny] != 1) continue;

                    grid[nx][ny] = 2;
                    fresh--;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
    // 시간 복잡도: O(m*n) - 모든 칸을 최대 한 번씩만 방문
    // 공간 복잡도: O(m*n) - BFS 큐 사용

}
